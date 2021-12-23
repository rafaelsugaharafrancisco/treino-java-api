package br.com.alura.rodizi_de_veiculos.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.rodizi_de_veiculos.dto.forms.VeiculoAlteracaoForm;
import br.com.alura.rodizi_de_veiculos.dto.forms.VeiculoInclusaoForm;
import br.com.alura.rodizi_de_veiculos.dto.success.VeiculoDto;
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
	@CacheEvict(value = "listaDeVeiculos", allEntries = true)
	public ResponseEntity<VeiculoDto> criar(@RequestBody @Valid VeiculoInclusaoForm veiculoDto, UriComponentsBuilder uriBuilder) {
	
		Veiculo veiculo = service.criar(veiculoDto.toVeiculo()).get();
		URI location = uriBuilder.path("/veiculos/{placa}").buildAndExpand(veiculo.getPlaca()).toUri();
		
		return ResponseEntity.created(location).body(new VeiculoDto(veiculo));
	}
	
	// localhost:8080/veiculos?page=0&size=5&sort=placa,asc
	@GetMapping
	@Cacheable(value = "listaDeVeiculos")
	public Page<VeiculoDto> listar(@PageableDefault(sort = "placa", size = 20) Pageable paginacao) {
		
		return VeiculoDto.converterParaPage(service.lista(paginacao).get());
	}
	
	@GetMapping("{placa}")
	public VeiculoDto pesquisar(@PathVariable String placa) {
		
		return new VeiculoDto(service.pesquisar(placa).get());
	}

	@PutMapping("{placa}")
	@CacheEvict(value = "listaDeVeiculos", allEntries = true)
	public VeiculoDto alterar(@RequestBody @Valid VeiculoAlteracaoForm veiculoDto, @PathVariable String placa) {
		Veiculo veiculo = service.alterar(veiculoDto.toVeiculo(), placa).get();
		
		return new VeiculoDto(veiculo);
	}
	
	@DeleteMapping("{placa}")
	@CacheEvict(value = "listaDeVeiculos", allEntries = true)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable String placa) {
		service.remover(placa);
	}
}
