package com.melquisedeque.easyCRI.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melquisedeque.easyCRI.domain.Cliente;
import com.melquisedeque.easyCRI.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElse(null);
	}
	
	public Cliente buscarCpf(String cpf) {
		
		Cliente obj = repo.findByCpf(cpf);
		
		return obj;
	}

}
