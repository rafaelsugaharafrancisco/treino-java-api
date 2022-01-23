package br.com.alura.rodizi_de_veiculos.rodizio;

import java.time.LocalDateTime;

import br.com.alura.rodizi_de_veiculos.models.DiaDaSemana;

public class Carro implements InformacaoRodizioVeiculo {

	
	@Override
	public DiaDaSemana obterDia(String placa) {
		char finalDePlaca = placa.charAt(7);
		DiaDaSemana diaDaSemana = null;

		switch (finalDePlaca) {
		case '1':
		case '2':
			diaDaSemana = DiaDaSemana.SEGUNDA;
			break;

		case '3':
		case '4':
			diaDaSemana = DiaDaSemana.TERCA;
			break;

		case '5':
		case '6':
			diaDaSemana = DiaDaSemana.QUARTA;
			break;

		case '7':
		case '8':
			diaDaSemana = DiaDaSemana.QUINTA;
			break;

		case '9':
		case '0':
			diaDaSemana = DiaDaSemana.SEXTA;
			break;
		}

		return diaDaSemana;
	}

	@Override
	public boolean verificarSeDiaEHora(DiaDaSemana diaDaSemana) {
		if (diaDaSemana.getValor() == LocalDateTime.now().getDayOfWeek().getValue()) {
			int hora = LocalDateTime.now().getHour();
			
			if ((hora >= 7 && hora <= 10) || (hora >= 17 && hora <= 20)) {
				return true;
			}
		}
		return false;
	}

}
