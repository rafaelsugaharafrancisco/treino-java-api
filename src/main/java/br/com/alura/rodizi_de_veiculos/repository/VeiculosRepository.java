package br.com.alura.rodizi_de_veiculos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.rodizi_de_veiculos.models.Veiculo;

public interface VeiculosRepository extends JpaRepository<Veiculo, Integer> {
	
	public Optional<Veiculo> findByPlaca(String placa);

}
