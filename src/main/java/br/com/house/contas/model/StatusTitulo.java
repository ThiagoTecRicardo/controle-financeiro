package br.com.house.contas.model;

public enum StatusTitulo {

	PENDENTE("Pendente"), PAGO("Pago");

	private String descricao;

	StatusTitulo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}