package br.com.mvarandas;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class SiswebApplication{

	public static void main(String[] args) {
		SpringApplication.run(SiswebApplication.class, args);
	}
	
	/* Corrige a data, casas decimais separadas com vírgula, etc */
	@Bean
	public LocaleResolver localeResolver(){
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

}
