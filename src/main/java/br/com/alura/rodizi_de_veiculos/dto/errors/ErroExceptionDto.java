package br.com.alura.rodizi_de_veiculos.dto.errors;

public class ErroExceptionDto {
	
	private String mensagem;
	
	public ErroExceptionDto(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}
}
