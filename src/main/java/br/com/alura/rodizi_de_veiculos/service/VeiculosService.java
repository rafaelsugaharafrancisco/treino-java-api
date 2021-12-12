package br.com.alura.rodizi_de_veiculos.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.rodizi_de_veiculos.exceptions.VeiculoJaCadastradoException;
import br.com.alura.rodizi_de_veiculos.exceptions.VeiculoNaoEncontradoException;
import br.com.alura.rodizi_de_veiculos.models.DiaDaSemana;
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
	public void remover(String placa) {
		Optional<Veiculo> optVeiculo = repository.findByPlaca(placa);
		
		if (!optVeiculo.isPresent()) {
			throw new VeiculoNaoEncontradoException();
		}

		repository.delete(optVeiculo.get());					
	}

	private DiaDaSemana obtemDiaDeRodizio(Veiculo veiculo) {
		char finalDePlaca = veiculo.getPlaca().charAt(7);
		DiaDaSemana diaDaSemana = null;
		
		switch(finalDePlaca) {
			case '1':
			case '2':
				diaDaSemana = DiaDaSemana.SEGUNDA;
				break;
			
			case '3':
			case '4':
				diaDaSemana = DiaDaSemana.TERCA;
				break;
		
			case '5':
			case '6':
				diaDaSemana = DiaDaSemana.QUARTA;
				break;
				
			case '7':
			case '8':
				diaDaSemana = DiaDaSemana.QUINTA;
				break;
				
			case '9':
			case '0':
				diaDaSemana = DiaDaSemana.SEXTA;
				break;
		}
		
		return diaDaSemana;
	}
	
}
