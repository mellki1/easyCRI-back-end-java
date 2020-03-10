package com.melquisedeque.easyCRI.entity.enums;

public enum TipoAto {
	
	CASAMENTO(1,"Casamento"),
	EDIFICACAO(2, "Edificação");
	
	private int cod;
	private String descricao;
	
	
	private TipoAto(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
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
