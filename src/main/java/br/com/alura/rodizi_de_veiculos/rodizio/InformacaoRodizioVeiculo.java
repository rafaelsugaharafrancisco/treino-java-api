package br.com.alura.rodizi_de_veiculos.rodizio;

import br.com.alura.rodizi_de_veiculos.models.DiaDaSemana;

public interface InformacaoRodizioVeiculo {

	public DiaDaSemana obterDia(String placa);
	
	public boolean verificarSeDiaEHora(DiaDaSemana diaDaSemana);
}
