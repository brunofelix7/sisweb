package br.com.mvarandas.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mvarandas.model.Views;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login")
	public String autenticar(@AuthenticationPrincipal User user){
		if (user != null) {
			return "redirect:/clientes";
		}
		return Views.LOGIN_VIEW;
	}
	
}
