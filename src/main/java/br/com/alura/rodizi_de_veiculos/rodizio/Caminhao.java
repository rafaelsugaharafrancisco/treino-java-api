package br.com.alura.rodizi_de_veiculos.rodizio;

import java.time.LocalDateTime;
import java.time.LocalTime;

import br.com.alura.rodizi_de_veiculos.models.DiaDaSemana;

public class Caminhao implements InformacaoRodizioVeiculo {

	@Override
	public DiaDaSemana obterDia(String placa) {

		return DiaDaSemana.SEGUNDA_A_SABADO;
	}

	@Override
	public boolean verificarSeDiaEHora(DiaDaSemana diaDaSemana) {
		
		switch (LocalDateTime.now().getDayOfWeek()) {
		case MONDAY:
		case TUESDAY:
		case WEDNESDAY:
		case THURSDAY:
		case FRIDAY:
			if ((LocalTime.now().isAfter(LocalTime.of(4,59,59)) && LocalTime.now().isBefore(LocalTime.of(9,0,1))) || 
					(LocalTime.now().isAfter(LocalTime.of(16,59,59)) && LocalTime.now().isBefore(LocalTime.of(21,0,1)))) {
				return true;
			}
		break;
		case SATURDAY:
			if (LocalTime.now().isAfter(LocalTime.of(9,59,59)) && LocalTime.now().isBefore(LocalTime.of(14,0,1))) {
				return true;
			}
		break;
		default:
		}	
		
		return false;
	}

}
