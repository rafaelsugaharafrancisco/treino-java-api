package br.com.alura.rodizi_de_veiculos.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String marca;
	
	private String modelo;
	
	private int ano;
	
	@Column(unique = true)
	private String placa;
	
	@Enumerated(EnumType.STRING)
	private DiaDaSemana diaDeRodizio;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	

	public DiaDaSemana getDiaDeRodizio() {
		return diaDeRodizio;
	}

	public void setDiaDeRodizio(DiaDaSemana diaDeRodizio) {
		this.diaDeRodizio = diaDeRodizio;
	}
}
