package br.edu.unoesc.desafiofullstackunoesc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.unoesc.desafiofullstackunoesc.domain.Beneficio;
import br.edu.unoesc.desafiofullstackunoesc.domain.Cabecalho;
import br.edu.unoesc.desafiofullstackunoesc.domain.Departamento;
import br.edu.unoesc.desafiofullstackunoesc.domain.Municipio;
import br.edu.unoesc.desafiofullstackunoesc.service.BeneficioService;

@Controller
@RequestMapping("/departamentos")
public class BeneficioController {

	@Autowired
	private BeneficioService service;

	Beneficio[] ben_pos_consulta = null;

	@GetMapping("/cadastrar")
	public String cadastrar(Cabecalho cabecalho, Beneficio beneficio) {
		return "/departamento/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("beneficio", service.buscarTodos());
		return "/departamento/lista";
	}

	@PostMapping("/consultar")
	public String consultar(@ModelAttribute Cabecalho cabecalho, BindingResult bindingResult, Model model,
			RedirectAttributes attr) throws IOException {
		model.addAttribute("cabecalho", cabecalho);
		try {
			model.addAttribute("beneficio",	buscaBeneficios(cabecalho.codibge, cabecalho.anoref, cabecalho.mesref, cabecalho.pag));
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Verifique os dados!");
			return "redirect:/departamentos/cadastrar";
		}
		// System.out.println(cabecalho.codibge + "AAAAAAAAAA");
		return "/departamento/cadastro";
	}

	@PostMapping("/salvar")
	public String salvar(@ModelAttribute Cabecalho cabecalho, BindingResult bindingResult, Model model,
			RedirectAttributes attr) throws IOException {
		model.addAttribute("cabecalho", cabecalho);
		model.addAttribute("beneficio",
				salvaBeneficios(cabecalho.codibge, cabecalho.anoref, cabecalho.mesref, cabecalho.pag));
		attr.addFlashAttribute("sucess", "Beneficios salvos!");
		return "redirect:/departamentos/cadastrar";
	}

	@RequestMapping(path = "/exportar")
	public void getAllEmployeesInCsv(HttpServletResponse servletResponse) throws IOException {
		servletResponse.setContentType("text/csv");
		servletResponse.addHeader("Content-Disposition", "attachment; filename=\"beneficios.csv\"");
		// csvExportService.writeEmployeesToCsv(servletResponse.getWriter());
	}

	public Beneficio[] buscaBeneficios(String codibge, String anoref, String mesref, String pag) throws IOException {
		URL url = new URL(
				"https://api.portaldatransparencia.gov.br/api-de-dados/auxilio-emergencial-beneficiario-por-municipio?codigoIbge="
						+ codibge + "&mesAno=" + anoref + mesref + "&pagina=" + pag);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("chave-api-dados", "86852ef80c2505cdc3728d23d30d4d06");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		Beneficio[] ben_beneficiario = new ObjectMapper().readValue(buffer, Beneficio[].class);
		ben_pos_consulta = ben_beneficiario;
		connection.disconnect();
		return ben_beneficiario;
	}

	public String salvaBeneficios(String codibge, String anoref, String mesref, String pag) throws IOException {
		URL url = new URL(
				"https://api.portaldatransparencia.gov.br/api-de-dados/auxilio-emergencial-beneficiario-por-municipio?codigoIbge="
						+ codibge + "&mesAno=" + anoref + mesref + "&pagina=" + pag);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("chave-api-dados", "86852ef80c2505cdc3728d23d30d4d06");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		Beneficio[] ben_beneficiario = new ObjectMapper().readValue(buffer, Beneficio[].class);
		connection.disconnect();

		try {
			for (int i = 0; i < ben_beneficiario.length; i++) {
				service.salvar(ben_beneficiario[i]);
				System.out.println("Salvou a tigrada");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return "sucesso";
	}
}