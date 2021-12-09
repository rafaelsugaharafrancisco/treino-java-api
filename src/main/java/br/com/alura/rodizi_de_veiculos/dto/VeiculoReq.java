package br.com.alura.rodizi_de_veiculos.dto;

import br.com.alura.rodizi_de_veiculos.models.Veiculo;

public class VeiculoReq {
	
	private String marca;
	
	private String modelo;
	
	private String placa;
	
	private int ano;
	
	public VeiculoReq() {}
	
	public VeiculoReq(String marca, String modelo, String placa, int ano) {
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.ano = ano;
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
	
	public Veiculo toVeiculo() {
		Veiculo veiculo = new Veiculo();
		veiculo.setModelo(modelo);
		veiculo.setAno(ano);
		veiculo.setPlaca(placa);
		veiculo.setMarca(marca);
		
		return veiculo;
	}
	
}
