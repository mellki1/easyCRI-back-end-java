package com.melquisedeque.easyCRI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melquisedeque.easyCRI.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	Cliente findByCpf(String cpf);
}
