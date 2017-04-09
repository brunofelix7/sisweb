package br.com.mvarandas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mvarandas.model.Routes;
import br.com.mvarandas.model.Views;

@Controller
public class ErrorPageController {
	
	@RequestMapping(value = Routes.ERROR_404)
	public String index(){
		return Views.ERROR_404;
	}

}
