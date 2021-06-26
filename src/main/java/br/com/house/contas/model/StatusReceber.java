package br.com.house.contas.model;

public enum StatusReceber {
	

	PENDENTE("Pendente"), PAGO("Pago");

	private String descricao;

	StatusReceber(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}


}
