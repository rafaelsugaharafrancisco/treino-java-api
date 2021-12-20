package br.com.alura.rodizi_de_veiculos.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class LoginForm {
	
	@NotBlank(message = "Não pode ser nulo ou branco")
	@Email(message = "Fomato inválido. Ex.: email@dominio.com")
	private String email;
	
	@NotBlank(message = "Não pode ser nulo ou branco")
	private String senha;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
