package br.com.alura.rodizi_de_veiculos.dto.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {
	
	@NotBlank(message = "Não pode ser nulo ou branco")
	@Email(message = "Fomato inválido. Ex.: email@dominio.com")
	private String email;
	
	@NotBlank(message = "Não pode ser nulo ou branco")
	private String senha;
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(email, senha);
	}

}
