package br.edu.unoesc.desafiofullstackunoesc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
	public String cadastrar(Departamento departamento) throws IOException {
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
		/*
		 * if(service.departamentoTemCargos(id)) { model.addAttribute("fail",
		 * "Há cargos vinculados, verifique!"); }else {
		 */
		service.excluir(id);
		model.addAttribute("sucess", "Departamento removido!");
		// }
		return listar(model); // Aponta para o metodo que redireciona "/departamento/lista";
	}

	// 69f77784d22e173e85bf5ff394593de7

	/*
	 * HttpHeaders createHeaders(){ return new HttpHeaders() {{ String auth =
	 * "chave-api-dados" + ":" + "59eeaf7bd6e9ac852374c683dbf911fc"; String
	 * authHeader = "Basic " + new String(auth); set( "Authorization", authHeader );
	 * }}; }
	 */

	/*
	 * public String teste() { RestTemplate template = new RestTemplate();
	 * UriComponents uri = UriComponentsBuilder.newInstance().scheme("https")
	 * .host("api.portaldatransparencia.gov.br")
	 * .path("api-de-dados/auxilio-emergencial-beneficiario-por-municipio")
	 * .queryParam("codIbge", "4203907") .queryParam("mesAno", 202012)
	 * .queryParam("pagina ", 1) .build();
	 * 
	 * HttpHeaders headers = new HttpHeaders();
	 * headers.add("chave-api-dados","59eeaf7bd6e9ac852374c683dbf911fc");
	 * HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	 * 
	 * ResponseEntity<String> result = template.(uri, HttpMethod.GET, null,
	 * String.class);
	 * 
	 * System.out.println(result);
	 * 
	 * //String result = template.exchange(uri, HttpMethod.POST, new
	 * HttpEntity<T>(createHeaders()), String.class); //String result =
	 * template.getForObject(uri.toString(), String.class);
	 * 
	 * return result.getBody(); }
	 */

	public String teste() throws IOException {
		 URL url = new URL("http://api.portaldatransparencia.gov.br/api-de-dados/orgaos-siafi?pagina=1");
		//URL url = new URL("http://ip.jsontest.com/");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");connection.setRequestProperty("chave-api-dados",
		"86852ef80c2505cdc3728d23d30d4d06");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String output;
		while ((output = buffer.readLine()) != null) {
			System.out.println(output);
		}
		connection.disconnect();
		return output;
	}
}
