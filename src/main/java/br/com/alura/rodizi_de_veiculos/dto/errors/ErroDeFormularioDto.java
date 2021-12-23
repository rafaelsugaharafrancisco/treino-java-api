package br.com.alura.rodizi_de_veiculos.dto.errors;

public class ErroDeFormularioDto extends ErroExceptionDto{

	private String campo;
	
	public ErroDeFormularioDto(String mensagem, String campo) {
		super(mensagem);
		this.campo = campo;
	}
	
	public String getCampo() {
		return campo;
	}

}
