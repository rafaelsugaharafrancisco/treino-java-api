package br.com.alura.rodizi_de_veiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.rodizi_de_veiculos.dto.DiaDeRodizioRes;
import br.com.alura.rodizi_de_veiculos.dto.VeiculoReq;
import br.com.alura.rodizi_de_veiculos.dto.VeiculoRes;
import br.com.alura.rodizi_de_veiculos.models.Veiculo;
import br.com.alura.rodizi_de_veiculos.service.VeiculosService;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController {
	
	private VeiculosService service;
	
	@Autowired
	public VeiculosController(VeiculosService service) {
		this.service = service;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public VeiculoRes criar(@RequestBody VeiculoReq veiculoDto) {
		Veiculo veiculo = service.criar(veiculoDto.toVeiculo()).get();
		
		return new VeiculoRes(veiculo.getMarca(), veiculo.getModelo(), veiculo.getPlaca(), veiculo.getAno());
	}
	
	@GetMapping("{placa}")
	public VeiculoRes pesquisar(@PathVariable String placa) {
		Veiculo veiculo = service.pesquisar(placa).get();
		
		return new VeiculoRes(veiculo.getMarca(), veiculo.getModelo(), veiculo.getPlaca(), veiculo.getAno());
	}

	@DeleteMapping("{placa}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable String placa) {
		service.remover(placa);
	}
	
	@GetMapping("{placa}/rodizio-hoje")
	public DiaDeRodizioRes verificaDiaDeRodizio(@PathVariable String placa) {
		return new DiaDeRodizioRes(service.verificaDiaDeRodizio(service.pesquisar(placa).get()));
	}
	
//	@GetMapping
//	public List<Veiculos> lista() {
//		return repository.findAll();
//	}
}
