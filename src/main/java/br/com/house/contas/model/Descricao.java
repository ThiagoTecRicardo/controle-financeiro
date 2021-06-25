package br.com.house.contas.model;

public enum Descricao {
	
	Vale("vale"), PAGAMENTO("Pagamaneto"), REEMBOLSO("reembolso"), OUTORS("outros");

	private String descricao;

	Descricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
