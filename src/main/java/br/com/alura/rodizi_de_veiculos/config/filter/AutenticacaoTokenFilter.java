package br.com.alura.rodizi_de_veiculos.config.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import br.com.alura.rodizi_de_veiculos.service.TokenService;

public class AutenticacaoTokenFilter extends OncePerRequestFilter {
	
	private TokenService tokenService;
	
	public AutenticacaoTokenFilter(TokenService tokenService) {
		this.tokenService = tokenService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request);
		boolean tokenValido = tokenService.isTokenValido(token);
		System.out.println(tokenValido);
		filterChain.doFilter(request, response);
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		
		if (token == null || token.isEmpty() || !token.startsWith("bearer ")) {
			return null;			
		}
		
		return token.substring(7, token.length());
	}

}
