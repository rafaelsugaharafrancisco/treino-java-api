package br.com.alura.rodizi_de_veiculos.rodizio;

import br.com.alura.rodizi_de_veiculos.models.DiaDaSemana;

public class RodizioDeVeiculo {
	
	private InformacaoRodizioVeiculo informacao;
	
	public RodizioDeVeiculo(InformacaoRodizioVeiculo informacao) {
		this.informacao = informacao;
	}

	public DiaDaSemana obterDia(String placa) {
		
		return this.informacao.obterDia(placa);
	}	
}
