package br.com.alura.rodizi_de_veiculos.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.alura.rodizi_de_veiculos.models.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${rodizio_de_veiculo.jwt.expiration}")
	private String expiration;
	
	@Value("${rodizio_de_veiculo.jwt.secretKey}")
	private String secretKey;

	public String gerarToken(Authentication authentication) {
		Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
		
		Date exp = new Date(new Date().getTime() + Long.parseLong(expiration));
				
		return Jwts.builder()
				   .setIssuer("Rodizio de veículo")
				   .setSubject(usuarioLogado.getEmail())
				   .setIssuedAt(new Date())
				   .setExpiration(exp)
				   .signWith(SignatureAlgorithm.HS256, secretKey)
				   .compact();
	}
}
