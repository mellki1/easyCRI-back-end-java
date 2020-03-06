package com.melquisedeque.easyCRI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melquisedeque.easyCRI.entity.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Integer>{

	Cliente findByCpf(String cpf);

	Cliente findByNome(String nome);
	
}
