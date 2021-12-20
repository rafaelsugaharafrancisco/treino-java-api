package br.com.alura.rodizi_de_veiculos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.alura.rodizi_de_veiculos.service.AutenticacaoService;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	private AutenticacaoService autenticacaoService;
	
	public SecurityConfigurations(AutenticacaoService autenticacaoService) {
		this.autenticacaoService = autenticacaoService;
	}
	// configurações de autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	//configuração de autorização
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/veiculos").permitAll()
		.antMatchers(HttpMethod.GET, "/veiculos/*").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin();
	}
	
	//configuração de recursos estáticos
	@Override
	public void configure(WebSecurity web) throws Exception {
	}
}
