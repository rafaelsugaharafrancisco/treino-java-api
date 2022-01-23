package br.com.alura.rodizi_de_veiculos.dto.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import br.com.alura.rodizi_de_veiculos.models.TipoDeVeiculo;
import br.com.alura.rodizi_de_veiculos.models.Veiculo;

public class VeiculoForm {
	
	@NotBlank(message = "Não pode ser nulo ou estar em branco")
	protected String marca;
	
	@NotBlank(message = "Não pode ser nulo ou estar em branco")
	protected String modelo;

	@NotBlank(message = "Não pode ser nulo ou estar em branco")
	protected String tipo;
	
	@NotBlank(message = "Não pode ser nulo ou estar em branco")
	@Pattern(regexp = "[A-Z]{3}-[0-9][A-Z0-9][0-9]{2}", message = "Valor inválido. Formato ex.: XXX-9X99 ou XXX-9999")
	protected String placa;
	
	@NotBlank(message = "Não pode ser nulo ou estar em branco")
	@Pattern(regexp = "\\d{4}", message = "Valor inválido. Formato ex.:  9999")
	protected String ano;

	
	public VeiculoForm() {}
	
	public VeiculoForm(String marca, String modelo, String placa, String ano, String tipo) {
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
		this.placa = placa;
		this.ano = ano;
	}
	
	public final void setMarca(String marca) {
		this.marca = marca;
	}

	public final void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public final void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public final void setPlaca(String placa) {
		this.placa = placa;
	}

	public final void setAno(String ano) {
		this.ano = ano;
	}
	
	public Veiculo toVeiculo() {
		Veiculo veiculo = new Veiculo();
		veiculo.setModelo(modelo);
		veiculo.setAno(Integer.parseInt(ano));
		veiculo.setPlaca(placa);
		veiculo.setMarca(marca);
		veiculo.setTipo(TipoDeVeiculo.valueOf(tipo.toUpperCase()));
		veiculo.setDiaDeRodizio(TipoDeVeiculo.valueOf(tipo.toUpperCase()).obterDiaDaSemana(placa));
		
		return veiculo;
	}
}
