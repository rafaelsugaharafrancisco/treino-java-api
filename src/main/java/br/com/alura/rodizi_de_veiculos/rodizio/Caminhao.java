package br.com.alura.rodizi_de_veiculos.rodizio;

import java.time.LocalDateTime;

import br.com.alura.rodizi_de_veiculos.models.DiaDaSemana;

public class Caminhao implements InformacaoRodizioVeiculo {

	@Override
	public DiaDaSemana obterDia(String placa) {

		return DiaDaSemana.SEGUNDA_A_SABADO;
	}

	@Override
	public boolean verificarSeDiaEHora(DiaDaSemana diaDaSemana) {
		int hora = LocalDateTime.now().getHour();
		
		switch (LocalDateTime.now().getDayOfWeek()) {
		case MONDAY:
		case TUESDAY:
		case WEDNESDAY:
		case THURSDAY:
		case FRIDAY:
			if ((hora >= 5 && hora <= 9) || (hora >= 17 && hora <= 21)) {
				return true;
			}
		break;
		case SATURDAY:
			if (hora >= 10 && hora <= 14) {
				return true;
			}
		break;
		default:
		}	
		
		return false;
	}

}
