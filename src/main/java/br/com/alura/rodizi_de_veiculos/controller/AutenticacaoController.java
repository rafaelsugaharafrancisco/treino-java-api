package br.com.alura.rodizi_de_veiculos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.rodizi_de_veiculos.dto.forms.LoginForm;
import br.com.alura.rodizi_de_veiculos.dto.success.TokenDto;
import br.com.alura.rodizi_de_veiculos.service.TokenService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	private AuthenticationManager authManager;
	private TokenService tokenService;
	
	@Autowired
	public AutenticacaoController(AuthenticationManager authManager, TokenService tokenService) {
		this.authManager = authManager;
		this.tokenService = tokenService;
	}
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form) {
		
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		
		try {
			Authentication authenticate = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authenticate);
			
			return ResponseEntity.ok(new TokenDto(token, "bearer"));			
			
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException(e.getMessage());
//			return ResponseEntity.badRequest().body(new ErroExceptionRes("usuário / senha inválido"));
		}
	}
}
