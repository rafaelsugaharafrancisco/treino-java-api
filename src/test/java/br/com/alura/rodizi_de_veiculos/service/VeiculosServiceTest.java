package br.com.alura.rodizi_de_veiculos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.alura.rodizi_de_veiculos.models.Veiculo;
import br.com.alura.rodizi_de_veiculos.repository.VeiculosRepository;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@AutoConfigureDataJpa
@ActiveProfiles("test")
public class VeiculosServiceTest {

	@Autowired
	private VeiculosRepository repository;
	
	@Test
	public void verificaVeiculoEhSandero() {
		String placa = "PQP-9D28";
		Veiculo veiculo = repository.findByPlaca(placa).get();
		assertNotNull(veiculo);
		assertEquals(veiculo.getModelo(), "Sandero");
	}
	
	@Test
	public void verificaVeiculoNaoCadastrado() {
		String placa = "EFC-2292";
		boolean existe = repository.findByPlaca(placa).isPresent();
		assertFalse(existe);
	}

}
