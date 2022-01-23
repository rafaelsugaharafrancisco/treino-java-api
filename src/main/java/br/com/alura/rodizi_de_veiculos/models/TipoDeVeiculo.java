package br.com.alura.rodizi_de_veiculos.models;

import br.com.alura.rodizi_de_veiculos.rodizio.Caminhao;
import br.com.alura.rodizi_de_veiculos.rodizio.Carro;
import br.com.alura.rodizi_de_veiculos.rodizio.InformacaoRodizioVeiculo;
import br.com.alura.rodizi_de_veiculos.rodizio.Moto;

public enum TipoDeVeiculo {

	CARRO(new Carro()),
	CAMINHAO(new Caminhao()),
	MOTO(new Moto());

	private final InformacaoRodizioVeiculo info;
	
	TipoDeVeiculo(InformacaoRodizioVeiculo info) {
		this.info = info;
	}

	public DiaDaSemana obterDiaDaSemana(String placa) {
		return info.obterDia(placa);
	}
	
	public boolean ehRodizio(DiaDaSemana diaDaSemana) {
		return info.verificarSeDiaEHora(diaDaSemana);
	}
}
