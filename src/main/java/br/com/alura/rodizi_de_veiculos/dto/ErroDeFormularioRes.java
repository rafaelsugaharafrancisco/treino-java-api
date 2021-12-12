package br.com.alura.rodizi_de_veiculos.dto;

public class ErroDeFormularioRes extends ErroExceptionRes{

	private String campo;
	
	public ErroDeFormularioRes(String mensagem, String campo) {
		super(mensagem);
		this.campo = campo;
	}
	
	public String getCampo() {
		return campo;
	}

}
