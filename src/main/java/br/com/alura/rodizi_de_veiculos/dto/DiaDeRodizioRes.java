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
		String dayOfWeek = LocalDateTime.now().getDayOfWeek().name();
		String diaDaSemana = "";
		
		switch(dayOfWeek) {
			case "MONDAY": diaDaSemana = "Segunda-feira";
			break;
			
			case "TUESDAY": diaDaSemana =  "Terça-feira";
			break;
			
			case "WEDNESDAY": diaDaSemana = "Quarta-feira";
			break;
			
			case "THURSDAY": diaDaSemana = "Quinta-feira";
			break;
			
			case "FRIDAY": diaDaSemana = "Sexta-feira";
			break;
			
			case "SATURDAY": diaDaSemana = "Sábado";
			break;
			
			case "SUNDAY": diaDaSemana = "Domingo";
			break;
		}
		
		return diaDaSemana;
	}
}
