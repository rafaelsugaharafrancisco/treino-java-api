package br.com.alura.rodizi_de_veiculos.dto;

import org.springframework.data.domain.Page;

import br.com.alura.rodizi_de_veiculos.models.DiaDaSemana;
import br.com.alura.rodizi_de_veiculos.models.TipoDeVeiculo;
import br.com.alura.rodizi_de_veiculos.models.Veiculo;

public class VeiculoDto {

	private String marca;
	
	private String modelo;
	
	private TipoDeVeiculo tipo;
	
	private String placa;
	
	private int ano;
	
	private DiaDaSemana diaDeRodizio;
	
	private boolean rodizio;
	
	public VeiculoDto(Veiculo veiculo) {
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.tipo = veiculo.getTipo();
		this.placa = veiculo.getPlaca();
		this.ano = veiculo.getAno();
		this.diaDeRodizio = veiculo.getDiaDeRodizio();
		this.rodizio = veiculo.getTipo().getTipoDeRodizioVeiculo().ehRodizio(veiculo.getDiaDeRodizio());
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public TipoDeVeiculo getTipo() {
		return tipo;
	}

	public String getPlaca() {
		return placa;
	}

	public int getAno() {
		return ano;
	}

	public DiaDaSemana getDiaDeRodizio() {
		return diaDeRodizio;
	}

	public boolean isRodizio() {
		return rodizio;
	}
	
//	public static List<VeiculoRes> converterParaLista(List<Veiculo> veiculos) {
//		return veiculos.stream().map(VeiculoRes::new).collect(Collectors.toList());
//	}
	
	public static Page<VeiculoDto> converterParaPage(Page<Veiculo> veiculos) {
		return veiculos.map(VeiculoDto::new);
	}
}
