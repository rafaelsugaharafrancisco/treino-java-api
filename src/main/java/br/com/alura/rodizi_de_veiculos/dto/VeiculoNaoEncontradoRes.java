package br.com.alura.rodizi_de_veiculos.dto;

public class VeiculoNaoEncontradoRes {
	
	private String mensagem;

	public VeiculoNaoEncontradoRes(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return mensagem;
	}
}
