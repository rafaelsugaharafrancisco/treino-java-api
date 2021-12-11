package br.com.alura.rodizi_de_veiculos.dto;

import java.time.LocalDateTime;

public class DiaDeRodizioRes {

	private String diaDaSemana;
	private String diaDeRodizio;
	
	public DiaDeRodizioRes(String diaDeRodizio) {
		this.diaDeRodizio = diaDeRodizio;
		this.diaDaSemana = this.obtemDiaDaSemana();
	}
	
	public String getDiaDeRodizio() {
		return diaDeRodizio;
	}
	
	public String getDiaDaSemana() {
		return diaDaSemana;
	}
	
	private String obtemDiaDaSemana() {
		String diaDaSemana = LocalDateTime.now().getDayOfWeek().name();
		
		switch(diaDaSemana) {
			case "MONDAY": return "Segunda-feira";
			
			case "TUESDAY": return "Terça-feira";
		
			case "WEDNESDAY": return "Quarta-feira";
				
			case "THURSDAY": return "Quinta-feira";
				
			case "FRIDAY": return "Sexta-feira";
			
			case "SATURDAY": return "Sábado";
			
			case "SUNDAY": return "Domingo";
		}
		
		return "";
	}
}
