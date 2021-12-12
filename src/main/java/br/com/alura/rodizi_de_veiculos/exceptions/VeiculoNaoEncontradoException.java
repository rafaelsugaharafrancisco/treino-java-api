package br.com.alura.rodizi_de_veiculos.exceptions;

public class VeiculoNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VeiculoNaoEncontradoException() {
		super("Veículo não encontrado!");
	}

}
