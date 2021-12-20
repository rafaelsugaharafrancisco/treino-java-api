package br.com.alura.rodizi_de_veiculos.service;

import java.time.DayOfWeek;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.alura.rodizi_de_veiculos.exceptions.VeiculoJaCadastradoException;
import br.com.alura.rodizi_de_veiculos.exceptions.VeiculoNaoEncontradoException;
import br.com.alura.rodizi_de_veiculos.models.Veiculo;
import br.com.alura.rodizi_de_veiculos.repository.VeiculosRepository;

@Component
public class VeiculosService implements Service<Veiculo> {

	private VeiculosRepository repository;
	
	public VeiculosService() {
	}
	
	@Autowired
	public VeiculosService(VeiculosRepository repository) {
		this.repository = repository;
	}
	
	@Override
	@Transactional
	public Optional<Veiculo> criar(Object object) {
		
		if (!(object instanceof Veiculo)) {
			throw new RuntimeException("O parâmetro desse método tem que ser tipo Veículo");
		}
		
		Veiculo veiculo = (Veiculo) object;
		
		if (repository.existsByPlaca(veiculo.getPlaca())){
			throw new VeiculoJaCadastradoException("Veículo placa " + veiculo.getPlaca() + " já cadastrado!");
		}
		
		veiculo.setDiaDeRodizio(this.obtemDiaDeRodizio(veiculo));
		return Optional.of(repository.save(veiculo));
	}

	public Optional<Page<Veiculo>> lista(Pageable paginacao) {
		
		return Optional.of(repository.findAll(paginacao));
	}
	
	@Override
	public Optional<Veiculo> pesquisar(String placa) {
		
		Optional<Veiculo> veiculo = repository.findByPlaca(placa);
		
		if (veiculo.isPresent()) return veiculo;
		
		throw new VeiculoNaoEncontradoException();
	}

	@Override
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
		veiculo.setAno(veiculoAlterar.getAno());	
		
		return Optional.of(veiculo);
	}

	@Override
	@Transactional
	public void remover(String placa) {
		Optional<Veiculo> optVeiculo = repository.findByPlaca(placa);
		
		if (!optVeiculo.isPresent()) {
			throw new VeiculoNaoEncontradoException();
		}

		repository.delete(optVeiculo.get());					
	}

	private DayOfWeek obtemDiaDeRodizio(Veiculo veiculo) {
		char finalDePlaca = veiculo.getPlaca().charAt(7);
		DayOfWeek diaDaSemana = null;
		
		switch(finalDePlaca) {
			case '1':
			case '2':
				diaDaSemana = DayOfWeek.MONDAY;
				break;
			
			case '3':
			case '4':
				diaDaSemana = DayOfWeek.TUESDAY;
				break;
		
			case '5':
			case '6':
				diaDaSemana = DayOfWeek.WEDNESDAY;
				break;
				
			case '7':
			case '8':
				diaDaSemana = DayOfWeek.THURSDAY;
				break;
				
			case '9':
			case '0':
				diaDaSemana = DayOfWeek.FRIDAY;
				break;
		}
		
		return diaDaSemana;
	}
}
