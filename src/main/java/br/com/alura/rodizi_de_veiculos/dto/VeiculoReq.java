package br.com.alura.rodizi_de_veiculos.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import br.com.alura.rodizi_de_veiculos.models.Veiculo;

public class VeiculoReq {
	
	@NotBlank(message = "Não pode ser nulo ou estar em branco")
	private String marca;
	
	@NotBlank(message = "Não pode ser nulo ou estar em branco")
	private String modelo;
	
	@NotBlank(message = "Não pode ser nulo ou estar em branco")
	@Pattern(regexp = "[A-Z]{3}-[0-9][A-Z0-9][0-9]{2}", message = "Valor inválido. Formato ex.: XXX-9X99")
	private String placa;
	
	@Pattern(regexp = "[0-9]{4}", message = "Valor inválido. Formato ex.:  9999")
	private String ano;
	
	public VeiculoReq() {}
	
	public VeiculoReq(String marca, String modelo, String placa, String ano) {
		this.marca = marca;
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

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public Veiculo toVeiculo() {
		Veiculo veiculo = new Veiculo();
		veiculo.setModelo(modelo);
		veiculo.setAno(Integer.parseInt(ano));
		veiculo.setPlaca(placa);
		veiculo.setMarca(marca);
		
		return veiculo;
	}
	
}
