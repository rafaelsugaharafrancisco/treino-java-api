package br.com.alura.rodizi_de_veiculos.dto.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import br.com.alura.rodizi_de_veiculos.models.Veiculo;

public class VeiculoAlteracaoForm {
	
	@NotBlank(message = "Não pode ser nulo ou estar em branco")
	private String marca;
	
	@NotBlank(message = "Não pode ser nulo ou estar em branco")
	private String modelo;
	
	@NotBlank(message = "Não pode ser nulo ou estar em branco")
	@Pattern(regexp = "\\d{4}", message = "Valor inválido. Formato ex.:  9999")
	private String ano;
	
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public Veiculo toVeiculo() {
		Veiculo veiculo = new Veiculo();
		veiculo.setModelo(modelo);
		veiculo.setAno(Integer.parseInt(ano));
		veiculo.setMarca(marca);
		
		return veiculo;
	}
	
}
