package br.com.alura.rodizi_de_veiculos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.alura.rodizi_de_veiculos.dto.VeiculoJaCadastradoRes;
import br.com.alura.rodizi_de_veiculos.dto.VeiculoNaoEncontradoRes;

@RestControllerAdvice
public class ErroExceptionHandler {
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(VeiculoNaoEncontradoException.class)
	public VeiculoNaoEncontradoRes veiculoNaoEncontrado(VeiculoNaoEncontradoException e) {
		return new VeiculoNaoEncontradoRes(e.getMessage());
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(VeiculoJaCadastradoException.class)
	public VeiculoJaCadastradoRes veiculoJaCadastrado(VeiculoJaCadastradoException e) {
		return new VeiculoJaCadastradoRes(e.getMessage());
	}
}
