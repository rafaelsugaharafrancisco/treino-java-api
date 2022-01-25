package br.com.alura.rodizi_de_veiculos.models;

import br.com.alura.rodizi_de_veiculos.rodizio.TipoDeRodizioVeiculo;

public enum TipoDeVeiculo {

	CARRO(TipoDeRodizioVeiculo.CARRO),
	CAMINHAO(TipoDeRodizioVeiculo.CAMINHAO),
	MOTO(TipoDeRodizioVeiculo.MOTO);

	private final TipoDeRodizioVeiculo tipoRodizio;
	
	TipoDeVeiculo(TipoDeRodizioVeiculo tipoDeRodizio) {
		this.tipoRodizio = tipoDeRodizio;
	}

	public TipoDeRodizioVeiculo getTipoDeRodizioVeiculo() {
		return tipoRodizio;
	}
}
