package br.com.alura.rodizi_de_veiculos.dto;

import br.com.alura.rodizi_de_veiculos.models.DiaDaSemana;

public class VeiculoRes {

	private String marca;
	
	private String modelo;
	
	private String placa;
	
	private int ano;
	
	private DiaDaSemana diaDeRodizio;
	
	public VeiculoRes(String marca, String modelo, String placa, int ano, DiaDaSemana diaDeRodizio) {
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.ano = ano;
		this.setDiaDeRodizio(diaDeRodizio);
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
}
