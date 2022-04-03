package br.edu.unoesc.desafiofullstackunoesc.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.unoesc.desafiofullstackunoesc.domain.Beneficio;
import br.edu.unoesc.desafiofullstackunoesc.domain.Cabecalho;
import br.edu.unoesc.desafiofullstackunoesc.service.BeneficioService;

@Controller
@RequestMapping("/dados")
public class BeneficioController {

	@Autowired
	private BeneficioService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Cabecalho cabecalho, Beneficio beneficio) {
		return "/dados/cadastro";
	}

	// MAPPING DA GUIA CONSULTAR API

	@PostMapping("/consultarapi")
	public String consultarapi(@ModelAttribute Cabecalho cabecalho, BindingResult bindingResult, Model model,
			RedirectAttributes attr) {
		try {
			model.addAttribute("cabecalho", cabecalho);
			model.addAttribute("beneficio",
					service.buscaBeneficios(cabecalho.codibge, cabecalho.anoref, cabecalho.mesref, cabecalho.pag));
			return "/dados/cadastro";
		} catch (Exception e) {
			e.printStackTrace();
			attr.addFlashAttribute("erro", "Verifique os dados preenchidos!");
			return "redirect:/dados/cadastrar";
		}
	}

	@PostMapping("/salvar")
	public String salvar(@ModelAttribute Cabecalho cabecalho, BindingResult bindingResult, Model model,
			RedirectAttributes attr) {
		if (!cabecalho.codibge.isEmpty() || !cabecalho.anoref.isEmpty() || !cabecalho.mesref.isEmpty()
				|| !cabecalho.pag.isEmpty()) {
			try {
				model.addAttribute("cabecalho", cabecalho);
				service.salvaBeneficios(cabecalho.codibge, cabecalho.anoref, cabecalho.mesref, cabecalho.pag);
				attr.addFlashAttribute("sucess", "Beneficios salvos!");
				return "redirect:/dados/cadastrar";

			} catch (Exception e) {
				attr.addFlashAttribute("fail", "Erro ao salvar!");
				return "redirect:/dados/cadastrar";
			}
		} else {
			attr.addFlashAttribute("alert", "Consulte os dados primeiro!");
			return "redirect:/dados/cadastrar";
		}
	}

	// MAPPING DADOS EXPORTACAO
	@GetMapping("/exportar")
	@ResponseBody
	public String exportar(@ModelAttribute Cabecalho cabecalho, HttpServletResponse r, BindingResult bindingResult,
			Model model, RedirectAttributes attr) {
		if (!cabecalho.codibge.isEmpty() || !cabecalho.anoref.isEmpty() || !cabecalho.mesref.isEmpty()
				|| !cabecalho.pag.isEmpty()) {
			model.addAttribute("cabecalho", cabecalho);
			try {
				byte[] retorno = service.exportaCSV(cabecalho.codibge, cabecalho.anoref, cabecalho.mesref,
						cabecalho.pag);
				final String tipo = "text/csv";
				r.setContentType(tipo);
				r.setContentLength(retorno.length);
				r.setHeader("Content-Disposition", "attachement; filename=\"csv-report.csv\"");
				attr.addFlashAttribute("sucess", "Dados exportados!");
				OutputStream output = r.getOutputStream();
				output.write(retorno);
				output.close();
				attr.addFlashAttribute("success", "Arquivo exportado!");
				return "redirect:/dados/cadastrar";
			} catch (Exception e) {
				e.printStackTrace();
				attr.addFlashAttribute("fail", "Ops, ocorreu um erro!");
				return "redirect:/dados/cadastrar";
			}
		} else {
			attr.addFlashAttribute("alert", "Consulte os dados primeiro!");
			return "redirect:/dados/cadastrar";
		}
	}

	// MAPPINGS DA GUIA DADOS SALVOS

	@GetMapping("/listar")
	public String listar(Cabecalho cabecalho, ModelMap model) {
		model.addAttribute("beneficio", service.buscarTodos());
		return "/dados/lista";
	}
}