package br.com.mvarandas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.mvarandas.model.Routes;

@Controller
public class IndexController {
	
	@RequestMapping(value = Routes.INDEX)
	public String index(){
		return "redirect:/clientes";
	}
	
}
