package br.com.alura.rodizi_de_veiculos.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.rodizi_de_veiculos.exceptions.VeiculoJaCadastradoException;
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
		
		if (!(object instanceof Veiculo)) {
			throw new RuntimeException("Parâmetro object tem que ser tipo Veículo");
		}
		
		Veiculo veiculo = (Veiculo) object;
		
		if (repository.existsByPlaca(veiculo.getPlaca())){
			throw new VeiculoJaCadastradoException("Veículo placa " + veiculo.getPlaca() + " já cadastrado!");
		}
		
		return Optional.of(repository.save(veiculo));
	}

	@Override
	public Optional<Veiculo> pesquisar(String placa) {
		
		Optional<Veiculo> veiculo = repository.findByPlaca(placa);
		
		if (veiculo.isPresent()) return veiculo;
		
		throw new VeiculoNaoEncontradoException();
	}

	@Override
	public Optional<Veiculo> alterar(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(String placa) {
		Optional<Veiculo> optVeiculo = repository.findByPlaca(placa);
		
		if (!optVeiculo.isPresent()) {
			throw new VeiculoNaoEncontradoException();
		}

		repository.delete(repository.findByPlaca(placa).get());					
	}

	public String verificaDiaDeRodizio(Veiculo veiculo) {
		char finalDePlaca = veiculo.getPlaca().charAt(7);
		String diaDaSemana = LocalDateTime.now().getDayOfWeek().name();
		boolean diaDeRodizio = false;
		
		switch(diaDaSemana) {
			case "MONDAY": 
				if (finalDePlaca == '1' || finalDePlaca == '2') diaDeRodizio = true;
				break;
			
			case "TUESDAY":
				if (finalDePlaca == '3' || finalDePlaca == '4') diaDeRodizio = true;
				break;
		
			case "WEDNESDAY":
				if (finalDePlaca == '5' || finalDePlaca == '6') diaDeRodizio = true;
				break;
				
			case "THURSDAY":
				if (finalDePlaca == '7' || finalDePlaca == '8') diaDeRodizio = true;
				break;
				
			case "FRIDAY":
				if (finalDePlaca == '9' || finalDePlaca == '0') diaDeRodizio = true;
				break;
		}
		
		if (diaDeRodizio) return "Sim";
		
		return "Não";
	}
	
}
