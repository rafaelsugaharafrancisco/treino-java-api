package br.com.alura.rodizi_de_veiculos.exceptions;

public class VeiculoJaCadastradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VeiculoJaCadastradoException(String mensagem) {
		super(mensagem);
	}
}
