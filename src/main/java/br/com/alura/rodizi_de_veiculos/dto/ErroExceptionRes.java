package br.com.alura.rodizi_de_veiculos.dto;

public class ErroExceptionRes {
	
	private String mensagem;
	
	public ErroExceptionRes(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}
}
