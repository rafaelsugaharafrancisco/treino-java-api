package br.com.alura.rodizi_de_veiculos.dto;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.alura.rodizi_de_veiculos.models.Veiculo;

public class VeiculoRes {

	private String marca;
	
	private String modelo;
	
	private String placa;
	
	private int ano;
	
	private DayOfWeek diaDeRodizio;
	
	private boolean rodizio;
	
	public VeiculoRes(Veiculo veiculo) {
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.placa = veiculo.getPlaca();
		this.ano = veiculo.getAno();
		this.diaDeRodizio = veiculo.getDiaDeRodizio();
		this.rodizio = veiculo.getDiaDeRodizio() == LocalDateTime.now().getDayOfWeek();
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public int getAno() {
		return ano;
	}

	public DayOfWeek getDiaDeRodizio() {
		return diaDeRodizio;
	}

	public boolean isRodizio() {
		return rodizio;
	}
	
//	public static List<VeiculoRes> converterParaLista(List<Veiculo> veiculos) {
//		return veiculos.stream().map(VeiculoRes::new).collect(Collectors.toList());
//	}
	
	public static Page<VeiculoRes> converterParaPage(Page<Veiculo> veiculos) {
		return veiculos.map(VeiculoRes::new);
	}
}
