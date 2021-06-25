package br.com.house.contas.model;

public enum Pessoa {
	
	THIAGO("Thiago"), KAREN("Karen");

	private String descricao;

	Pessoa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
