package br.com.alura.rodizi_de_veiculos.controller;

import javax.validation.Valid;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
		
		return new VeiculoRes(service.criar(veiculoDto.toVeiculo()).get());
	}
	
	// localhost:8080/veiculos?page=0&size=5&sort=placa,asc
	@Cacheable(value = "listaDeVeiculos")
	@GetMapping
	public Page<VeiculoRes> listar(@PageableDefault(sort = "placa") Pageable paginacao) {
		
		return VeiculoRes.converterParaPage(service.lista(paginacao).get());
	}
	
	@GetMapping("{placa}")
	public VeiculoRes pesquisar(@PathVariable String placa) {
		
		return new VeiculoRes(service.pesquisar(placa).get());
	}

	@PutMapping("{placa}")
	public VeiculoRes alterar(@RequestBody @Valid VeiculoAlteracao veiculoDto, @PathVariable String placa) {
		Veiculo veiculo = service.alterar(veiculoDto.toVeiculo(), placa).get();
		
		return new VeiculoRes(veiculo);
	}
	
	@DeleteMapping("{placa}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable String placa) {
		service.remover(placa);
	}
}
