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
    @JoinColumn(name="idCliente", nullable=false)
	private Cliente cliente;
	
	private TipoAto tipoAto;
	
	public Requerimento() {}

	public Requerimento(Integer id, Cliente cliente, TipoAto tipoAto) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.tipoAto = tipoAto;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Requerimento other = (Requerimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
