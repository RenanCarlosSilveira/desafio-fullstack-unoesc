package br.edu.unoesc.desafiofullstackunoesc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@GetMapping({"/","/login" })
	public String login() {
		return "login";
	}
	
	@GetMapping({ "/login-error" })
	public String loginError(ModelMap model) {
		model.addAttribute("alerta", "erro");
		model.addAttribute("titulo", "Informações inválidas!");
		model.addAttribute("texto", "Dados incorretos, tente novamente!");
		model.addAttribute("subtexto", "");
		return "login";
	}
}

/*@Controller
@RequestMapping("/logins")
public class LoginController {
	@GetMapping({"/","/login"})
	public String login() {
		return "login";
	}
	
	@GetMapping({ "/login-error" })
	public String loginError(ModelMap model) {
		model.addAttribute("alerta", "erro");
		model.addAttribute("titulo", "Informações inválidas!");
		model.addAttribute("texto", "Dados incorretos, tente novamente!");
		model.addAttribute("subtexto", "");
		return "login";
	}
	
	@GetMapping({ "/login-criado" })
	public String loginCriado(ModelMap model) {
		model.addAttribute("alerta", " ");
		model.addAttribute("titulo", "Usuário Cadastrado!");
		model.addAttribute("texto", "Seu acesso já está disponível!");
		model.addAttribute("subtexto", "");
		return "/login";
	}
}*/