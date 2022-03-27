package br.edu.unoesc.desafiofullstackunoesc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping({"/","/login" })
	public String login() {
		return "login";
	}
	
	@GetMapping({ "/login-error" })
	public String loginError(ModelMap model) {
		model.addAttribute("alerta", "erro");
		model.addAttribute("titulo", "Cedencial inválida!");
		model.addAttribute("texto", "Dados incorretos, tente novamente!");
		model.addAttribute("subtexto", "Acesso para usuarios validados!");
		return "login";
	}
}