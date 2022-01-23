package br.com.alura.rodizi_de_veiculos.rodizio;

import br.com.alura.rodizi_de_veiculos.models.DiaDaSemana;

public class Moto implements InformacaoRodizioVeiculo {

	@Override
	public DiaDaSemana obterDia(String placa) {

		return null;
	}

	@Override
	public boolean verificarSeDiaEHora(DiaDaSemana diaDaSemana) {

		return false;
	}

}
