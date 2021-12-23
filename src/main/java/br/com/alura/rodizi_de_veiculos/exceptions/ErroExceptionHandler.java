package br.com.alura.rodizi_de_veiculos.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.alura.rodizi_de_veiculos.dto.errors.ErroDeFormularioDto;
import br.com.alura.rodizi_de_veiculos.dto.errors.ErroDeLoginDto;
import br.com.alura.rodizi_de_veiculos.dto.errors.ErroExceptionDto;
import br.com.alura.rodizi_de_veiculos.dto.warnings.VeiculoJaCadastradoDto;
import br.com.alura.rodizi_de_veiculos.dto.warnings.VeiculoNaoEncontradoDto;

@RestControllerAdvice
public class ErroExceptionHandler {
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(VeiculoNaoEncontradoException.class)
	public VeiculoNaoEncontradoDto veiculoNaoEncontrado(VeiculoNaoEncontradoException e) {
		return new VeiculoNaoEncontradoDto(e.getMessage());
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadCredentialsException.class)
	public ErroDeLoginDto erroDeLogin(BadCredentialsException e) {
		return new ErroDeLoginDto(e.getMessage());
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(VeiculoJaCadastradoException.class)
	public VeiculoJaCadastradoDto veiculoJaCadastrado(VeiculoJaCadastradoException e) {
		return new VeiculoJaCadastradoDto(e.getMessage());
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeFormularioDto> erroDeFormulario(MethodArgumentNotValidException e) {
		List<ErroDeFormularioDto> errosDeFormulario = new ArrayList<>();
		List<FieldError> camposComErros = e.getBindingResult().getFieldErrors();
		
		camposComErros.forEach(erro -> {
			errosDeFormulario.add(new ErroDeFormularioDto(erro.getDefaultMessage(), erro.getField()));
		});
		
		return errosDeFormulario;
	}
	
	@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ErroExceptionDto erroMetodoHttp(HttpRequestMethodNotSupportedException e) {
		return new ErroExceptionDto(e.getMessage());
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ErroExceptionDto erroGenerico(Exception e) {
		return new ErroExceptionDto(e.getMessage());
	}
}
