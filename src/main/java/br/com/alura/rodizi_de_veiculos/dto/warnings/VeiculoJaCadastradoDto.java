package br.com.alura.rodizi_de_veiculos.dto.warnings;

import br.com.alura.rodizi_de_veiculos.dto.errors.ErroExceptionDto;

public class VeiculoJaCadastradoDto extends ErroExceptionDto {

	public VeiculoJaCadastradoDto(String mensagem) {
		super(mensagem);
	}

}
