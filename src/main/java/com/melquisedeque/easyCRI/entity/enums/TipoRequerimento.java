package com.melquisedeque.easyCRI.entity.enums;

public enum TipoRequerimento {
	
	AVERBACAO(1, "Averbação"),
	REGISTRO(2, "Registro");
	
	private int cod;
	private String descricao;
	
	private TipoRequerimento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoRequerimento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (TipoRequerimento x : TipoRequerimento.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id iválido: " + cod);
	}
}
