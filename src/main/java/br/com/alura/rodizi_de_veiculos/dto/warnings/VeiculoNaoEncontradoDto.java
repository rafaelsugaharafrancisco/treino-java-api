package br.com.alura.rodizi_de_veiculos.dto.warnings;

import br.com.alura.rodizi_de_veiculos.dto.errors.ErroExceptionDto;

public class VeiculoNaoEncontradoDto extends ErroExceptionDto {

	public VeiculoNaoEncontradoDto(String mensagem) {
		super(mensagem);
	}
}
