package br.com.alura.rodizi_de_veiculos.dto;

import br.com.alura.rodizi_de_veiculos.models.Montadora;

public class VeiculoRes {

	private String marca;
	
	private String modelo;
	
	private String placa;
	
	private int ano;
	
	public VeiculoRes(Montadora marca, String modelo, String placa, int ano) {
		this.marca = marca.getNome();
		this.modelo = modelo;
		this.placa = placa;
		this.ano = ano;
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
}
