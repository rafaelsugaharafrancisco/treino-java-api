package br.com.alura.rodizi_de_veiculos.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.rodizi_de_veiculos.exceptions.VeiculoNaoEncontradoException;
import br.com.alura.rodizi_de_veiculos.models.Veiculo;
import br.com.alura.rodizi_de_veiculos.repository.VeiculosRepository;

@Component
public class VeiculosService implements Service<Veiculo> {

	private VeiculosRepository repository;
	
	@Autowired
	public VeiculosService(VeiculosRepository repository) {
		this.repository = repository;
	}
	
	@Override
	@Transactional
	public Optional<Veiculo> criar(Object object) {
		Veiculo veiculo = null;
		
		if (object instanceof Veiculo) {
			veiculo = (Veiculo) object;
		} else {
			throw new RuntimeException("Parâmetro object tem que ser tipo Veículo");
		}
		
		if (repository.existsByPlaca(veiculo.getPlaca())){
		}
		
		return Optional.of(repository.save(veiculo));
	}

	@Override
	public Optional<Veiculo> pesquisar(String string) {
		Optional<Veiculo> veiculo = repository.findByPlaca(string);
		
		if (veiculo.isPresent()) return veiculo;
		
		throw new VeiculoNaoEncontradoException();
	}

	@Override
	public Optional<Veiculo> alterar(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(String string) {
		// TODO Auto-generated method stub
	}

	
}
