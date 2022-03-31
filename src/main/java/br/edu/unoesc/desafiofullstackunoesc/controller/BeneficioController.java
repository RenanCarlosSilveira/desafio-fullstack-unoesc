package br.edu.unoesc.desafiofullstackunoesc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

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

	
	@GetMapping("/cadastrar")
	public String cadastrar(Cabecalho cabecalho, Beneficio beneficio){
		return "/departamento/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("beneficio", service.buscarTodos());
		return "/departamento/lista";
	}

	@PostMapping("/consultar")
	public String consultar(@ModelAttribute Cabecalho cabecalho, BindingResult bindingResult, Model model) throws IOException {
		buscaBeneficios(cabecalho.codibge, cabecalho.anoref, cabecalho.mesref, cabecalho.pag);
		//model.addAttribute("beneficio", service.buscarTodos());
		//attr.addFlashAttribute("sucess", "Departamento salvo!");
		return "/departamento/cadastro";
	}
	
    @RequestMapping(path = "/exportar")
    public void getAllEmployeesInCsv(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"beneficios.csv\"");
        //csvExportService.writeEmployeesToCsv(servletResponse.getWriter());
    }

	/*
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
		/*service.excluir(id);
		model.addAttribute("sucess", "Departamento removido!");
		// }
		return listar(model); // Aponta para o metodo que redireciona "/departamento/lista";
	}*/

	public String buscaBeneficios(String codibge, String anoref, String mesref, String pag) throws IOException {
		
		URL url = new URL("https://api.portaldatransparencia.gov.br/api-de-dados/auxilio-emergencial-beneficiario-por-municipio?codigoIbge="+codibge+"&mesAno="+anoref+mesref+"&pagina="+pag);
		
		//URL url = new URL("https://api.portaldatransparencia.gov.br/api-de-dados/auxilio-emergencial-beneficiario-por-municipio?codigoIbge=4209003%20&mesAno=202108&pagina=1");
		// URL url = new URL("http://ip.jsontest.com/");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("chave-api-dados", "86852ef80c2505cdc3728d23d30d4d06");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String output = "";

		Beneficio[] ben_beneficiario = new ObjectMapper().readValue(buffer, Beneficio[].class);

		for (int i = 0; i < ben_beneficiario.length; i++) {
			System.out.println(ben_beneficiario[i].beneficiario.nome);
			System.out.println(ben_beneficiario[i].valor);
			service.salvar(ben_beneficiario[i]);
		}
		connection.disconnect();
		return output;
	}
}
