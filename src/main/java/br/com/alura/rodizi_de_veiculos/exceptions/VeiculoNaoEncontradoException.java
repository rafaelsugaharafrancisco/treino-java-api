package br.com.alura.rodizi_de_veiculos.exceptions;

public class VeiculoNaoEncontradoException extends RuntimeException {

	public VeiculoNaoEncontradoException() {
		super("Veículo não encontrado!");
	}

}
