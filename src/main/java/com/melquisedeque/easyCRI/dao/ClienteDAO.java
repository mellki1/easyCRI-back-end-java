package com.melquisedeque.easyCRI.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melquisedeque.easyCRI.entity.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Integer>{

	Optional<Cliente> findByCpf(String cpf);

	Optional<Cliente> findByNome(String nome);
	
	List<Cliente> findAll();

}
