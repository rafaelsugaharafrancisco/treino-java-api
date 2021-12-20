package br.com.alura.rodizi_de_veiculos.models;

public enum DiaDaSemana {

	SEGUNDA(1),
	TERCA(2),
	QUARTA(3),
	QUINTA(4),
	SEXTA(5);
	
	private int valor;
	
	DiaDaSemana(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
}
