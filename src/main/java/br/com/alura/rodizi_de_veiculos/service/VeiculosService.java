package br.com.alura.rodizi_de_veiculos.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.alura.rodizi_de_veiculos.exceptions.VeiculoJaCadastradoException;
import br.com.alura.rodizi_de_veiculos.exceptions.VeiculoNaoEncontradoException;
import br.com.alura.rodizi_de_veiculos.models.Veiculo;
import br.com.alura.rodizi_de_veiculos.repository.VeiculosRepository;

@Service
public class VeiculosService {

	private VeiculosRepository repository;
	
	public VeiculosService() {
	}
	
	@Autowired
	public VeiculosService(VeiculosRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public Optional<Veiculo> criar(Object object) {
		
		if (!(object instanceof Veiculo)) {
			throw new RuntimeException("O parâmetro desse método tem que ser tipo Veículo");
		}
		
		Veiculo veiculo = (Veiculo) object;
		
		if (repository.existsByPlaca(veiculo.getPlaca())){
			throw new VeiculoJaCadastradoException("Veículo placa " + veiculo.getPlaca() + " já cadastrado!");
		}
		
		return Optional.of(repository.save(veiculo));
	}

	public Optional<Page<Veiculo>> lista(Pageable paginacao) {
		
		return Optional.of(repository.findAll(paginacao));
	}
	
	public Optional<Veiculo> pesquisar(String placa) {
		
		Optional<Veiculo> veiculo = repository.findByPlaca(placa);
		
		if (veiculo.isPresent()) return veiculo;
		
		throw new VeiculoNaoEncontradoException();
	}

	@Transactional
	public Optional<Veiculo> alterar(Object object, String placa) {
		
		if (!(object instanceof Veiculo))
			throw new RuntimeException("O parâmetro desse método tem que ser tipo Veículo");
		
		Veiculo veiculoAlterar = (Veiculo) object;
		
		Optional<Veiculo> optVeiculo = repository.findByPlaca(placa);
		
		if (!optVeiculo.isPresent()) {
			throw new VeiculoNaoEncontradoException();
		}
			
		Veiculo veiculo = optVeiculo.get();
		veiculo.setMarca(veiculoAlterar.getMarca());
		veiculo.setModelo(veiculoAlterar.getModelo());
		veiculo.setTipo(veiculoAlterar.getTipo());
		veiculo.setAno(veiculoAlterar.getAno());	
		veiculo.setDiaDeRodizio(veiculoAlterar.getDiaDeRodizio());
		
		return Optional.of(veiculo);
	}

	@Transactional
	public void remover(String placa) {
		Optional<Veiculo> optVeiculo = repository.findByPlaca(placa);
		
		if (!optVeiculo.isPresent()) {
			throw new VeiculoNaoEncontradoException();
		}

		repository.delete(optVeiculo.get());					
	}
}