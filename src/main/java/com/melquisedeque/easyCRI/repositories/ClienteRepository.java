package com.melquisedeque.easyCRI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.melquisedeque.easyCRI.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
