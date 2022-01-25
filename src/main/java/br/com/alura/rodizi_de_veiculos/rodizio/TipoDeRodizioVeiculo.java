package br.com.alura.rodizi_de_veiculos.rodizio;

import br.com.alura.rodizi_de_veiculos.models.DiaDaSemana;

public enum TipoDeRodizioVeiculo {
	CARRO(new Carro()),
	CAMINHAO(new Caminhao()),
	MOTO(new Moto());

	private final InformacaoRodizioVeiculo info;
	
	TipoDeRodizioVeiculo(InformacaoRodizioVeiculo info) {
		this.info = info;
	}

	public DiaDaSemana obterDiaDaSemana(String placa) {
		return info.obterDia(placa);
	}
	
	public boolean ehRodizio(DiaDaSemana diaDaSemana) {
		return info.verificarSeDiaEHora(diaDaSemana);
	}
}
