package br.com.alura.rodizi_de_veiculos.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.alura.rodizi_de_veiculos.models.DiaDaSemana;
import br.com.alura.rodizi_de_veiculos.models.Veiculo;

public class VeiculoRes {

	private String marca;
	
	private String modelo;
	
	private String placa;
	
	private int ano;
	
	private DiaDaSemana diaDeRodizio;
	
	private boolean rodizio;
	
	public VeiculoRes(Veiculo veiculo) {
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.placa = veiculo.getPlaca();
		this.ano = veiculo.getAno();
		this.diaDeRodizio = veiculo.getDiaDeRodizio();
		this.rodizio = veiculo.getDiaDeRodizio().getValor() == LocalDateTime.now().getDayOfWeek().getValue();
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public DiaDaSemana getDiaDeRodizio() {
		return diaDeRodizio;
	}

	public void setDiaDeRodizio(DiaDaSemana diaDeRodizio) {
		this.diaDeRodizio = diaDeRodizio;
	}
	
	public static List<VeiculoRes> converterParaLista(List<Veiculo> veiculos) {
		return veiculos.stream().map(VeiculoRes::new).collect(Collectors.toList());
	}
	
	public static Page<VeiculoRes> converterParaPage(Page<Veiculo> veiculos) {
		return veiculos.map(VeiculoRes::new);
	}

	public boolean isRodizio() {
		return rodizio;
	}

	public void setRodizio(boolean rodizio) {
		this.rodizio = rodizio;
	}
}
