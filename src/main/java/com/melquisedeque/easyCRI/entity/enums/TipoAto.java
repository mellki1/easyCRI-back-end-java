package com.melquisedeque.easyCRI.entity.enums;

public enum TipoAto {

	ABERTURA_DE_MATRICULA (1, "Abertura de matrícula", "Averbação"),
	ADITIVO (2, "Aditivo", "Averbação"),
	ALTERACAO_CPF (3, "Alteração de CPF", "Averbação"),
	ALTERACAO_NOME (4, "Alteração de nome", "Averbação"),
	ALTERACAO_RG (5, "Alteração de RG", "Averbação");
	
	private Integer cod;
	private String nome;
	private String tipoRequerimento;

	private TipoAto(Integer cod, String tipoRequerimento, String nome) {
		this.cod = cod;
		this.tipoRequerimento = tipoRequerimento;
		this.nome = nome;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getTipoRequerimento() {
		return tipoRequerimento;
	}

	public void setTipoRequerimento(String tipoRequerimento) {
		this.tipoRequerimento = tipoRequerimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public static TipoAto toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (TipoAto x : TipoAto.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id iválido: " + cod);
	}
}
