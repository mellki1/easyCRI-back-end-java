package com.melquisedeque.easyCRI.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.melquisedeque.easyCRI.entity.enums.TipoAto;

@Entity
public class Requerimento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
    @JoinColumn
	Cliente cliente;
    
	private String data;
	
	private TipoAto tipoAto;
	
	public Requerimento() {}

	public Requerimento(Integer id, String data) {
		super();
		this.id = id;
		this.data = data;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public TipoAto getTipoAto() {
		return tipoAto;
	}

	public void setTipoAto(TipoAto tipoAto) {
		this.tipoAto = tipoAto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

	

}