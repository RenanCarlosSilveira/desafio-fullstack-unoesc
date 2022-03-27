package br.edu.unoesc.desafiofullstackunoesc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.unoesc.desafiofullstackunoesc.domain.Departamento;
import br.edu.unoesc.desafiofullstackunoesc.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

	
	@Autowired
	private DepartamentoService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {
		teste();
		return "/departamento/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("departamentos", service.buscarTodos());
		return "/departamento/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Departamento departamento, RedirectAttributes attr) {
		service.salvar(departamento);
		attr.addFlashAttribute("sucess", "Departamento salvo!");
		return "redirect:/departamentos/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") long id, ModelMap model) {
		model.addAttribute("departamento", service.buscarPorId(id));
		return "/departamento/cadastro";
	}

	@PostMapping("/editar")
	public String editar(Departamento departamento, RedirectAttributes attr) {
		service.editar(departamento);
		attr.addFlashAttribute("sucess", "Departamento atualizado!");
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		/*if(service.departamentoTemCargos(id)) {
			model.addAttribute("fail", "Há cargos vinculados, verifique!");
		}else {*/
			service.excluir(id);
			model.addAttribute("sucess", "Departamento removido!");
		//}
		return listar(model); //Aponta para o metodo que redireciona "/departamento/lista";
	}
	
	//cf6a6a77ca1cf260c0ae46b1f60da92a
	
	public String teste() {
		RestTemplate template = new RestTemplate();
		UriComponents uri = UriComponentsBuilder.newInstance().scheme("https")
				.host("api.portaldatransparencia.gov.br")
				.path("api-de-dados/auxilio-emergencial-beneficiario-por-municipio/")
				
				.queryParam("codIbge", "4203907")
				.queryParam("mesAno", 202012)
				.queryParam("pagina ", 1)
				.build();
		
	
		 String result = template.getForObject(uri.toString(), String.class);
		 return result;
	}

}

