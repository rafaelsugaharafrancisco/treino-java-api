package br.com.alura.rodizi_de_veiculos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.rodizi_de_veiculos.dto.VeiculoAlteracao;
import br.com.alura.rodizi_de_veiculos.dto.VeiculoInclusao;
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
	public VeiculoRes criar(@RequestBody @Valid VeiculoInclusao veiculoDto) {
		Veiculo veiculo = service.criar(veiculoDto.toVeiculo()).get();
		
		return new VeiculoRes(veiculo.getMarca(), 
				veiculo.getModelo(), 
				veiculo.getPlaca(), 
				veiculo.getAno(), 
				veiculo.getDiaDeRodizio());
	}
	
	@GetMapping("{placa}")
	public VeiculoRes pesquisar(@PathVariable String placa) {
		Veiculo veiculo = service.pesquisar(placa).get();
		
		return new VeiculoRes(veiculo.getMarca(), 
				veiculo.getModelo(), 
				veiculo.getPlaca(), 
				veiculo.getAno(),
				veiculo.getDiaDeRodizio());
	}

	@PutMapping("{placa}")
	public VeiculoRes alterar(@RequestBody @Valid VeiculoAlteracao veiculoDto, @PathVariable String placa) {
		Veiculo veiculo = service.alterar(veiculoDto.toVeiculo(), placa).get();
		
		return new VeiculoRes(veiculo.getMarca(), 
				veiculo.getModelo(), 
				veiculo.getPlaca(), 
				veiculo.getAno(),
				veiculo.getDiaDeRodizio());
	}
	
	@DeleteMapping("{placa}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable String placa) {
		service.remover(placa);
	}
	
//	@GetMapping
//	public List<Veiculos> lista() {
//		return repository.findAll();
//	}
}
