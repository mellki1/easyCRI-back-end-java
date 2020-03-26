package com.melquisedeque.easyCRI.entity.enums;

public enum Titulo {

	ADITIVO (1, "Aditivo"),
	ESCRITURA (2, "Escritura"),
	CEDULA (3, "Cédula"),
	BAIXA (4, "Baixa"),
	REQUERIMENTO (5, "Requerimento");
	
	private Integer cod;
	private String nome;
	
	private Titulo(Integer cod, String nome) {
		this.cod = cod;
		this.nome = nome;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static Titulo toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (Titulo x : Titulo.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id iválido: " + cod);
	}
}
