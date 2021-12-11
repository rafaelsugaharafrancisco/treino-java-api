package br.com.alura.rodizi_de_veiculos.service;

import java.util.Optional;

public interface Service<T> {
	
	public Optional<T> criar(Object object);
	
	public Optional<T> pesquisar(String string);
	
	public Optional<T> alterar(Object object, String string);
	
	public void remover(String string);
}
