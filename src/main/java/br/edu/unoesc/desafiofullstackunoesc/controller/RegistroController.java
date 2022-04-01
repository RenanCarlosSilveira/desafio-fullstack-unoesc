package br.edu.unoesc.desafiofullstackunoesc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.unoesc.desafiofullstackunoesc.domain.Usuario;
import br.edu.unoesc.desafiofullstackunoesc.service.UsuarioService;

@Controller
@RequestMapping("/registros")
public class RegistroController {

	@Autowired
	UsuarioService service;

	@GetMapping({ "/registro" })
	public String login(@ModelAttribute Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "/registro";
	}

	@PostMapping("/salvar")
	public String salvar(@ModelAttribute Usuario usuario, ModelMap model, BindingResult result) {
		model.addAttribute("usuario", usuario);
		service.salvarUsuario(usuario);
		model.addAttribute("alerta", " ");
		model.addAttribute("titulo", "Usuário Cadastrado!");
		model.addAttribute("texto", " ");
		model.addAttribute("subtexto", "Seu acesso está diponível, retorne à página de login.");
		return "registro";
	}

	/*
	 * @GetMapping({ "/registro-error" }) public String loginError(ModelMap model) {
	 * model.addAttribute("alerta", "erro"); model.addAttribute("titulo",
	 * "Preencha os dados"); model.addAttribute("texto", "Tente novamente!");
	 * model.addAttribute("subtexto", "Complete o formulario com dados validos!");
	 * return "registro"; }
	 */
}