package br.com.mvarandas;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import br.com.mvarandas.model.Routes;

/**
 * Classe que configura e realiza a segurança do sistema
 * @author Bruno Felix
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private static final String USERNAME = "admin";
	private static final String PASSWORD = "admin";
	private static final String ROLE 	 = "ADMIN";
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
			.withUser(USERNAME)
			.password(PASSWORD)
			.roles(ROLE);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers("/layout/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and().formLogin().loginPage(Routes.LOGIN)
			.permitAll()
			.and().logout()
			.logoutRequestMatcher(new AntPathRequestMatcher(Routes.LOGOUT));
	}
	
}
