package br.com.alura.rodizi_de_veiculos.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.alura.rodizi_de_veiculos.dto.ErroDeFormularioRes;
import br.com.alura.rodizi_de_veiculos.dto.ErroExceptionRes;
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
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeFormularioRes> erroDeFormulario(MethodArgumentNotValidException e) {
		List<ErroDeFormularioRes> errosDeFormulario = new ArrayList<>();
		List<FieldError> camposComErros = e.getBindingResult().getFieldErrors();
		
		camposComErros.forEach(erro -> {
			errosDeFormulario.add(new ErroDeFormularioRes(erro.getDefaultMessage(), erro.getField()));
		});
		
		return errosDeFormulario;
	}
	
	@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ErroExceptionRes erroMetodoHttp(HttpRequestMethodNotSupportedException e) {
		return new ErroExceptionRes(e.getMessage());
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ErroExceptionRes erroGenerico(Exception e) {
		return new ErroExceptionRes(e.getMessage());
	}
}
