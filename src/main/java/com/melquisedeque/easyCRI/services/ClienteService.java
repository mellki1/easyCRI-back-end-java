package com.melquisedeque.easyCRI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melquisedeque.easyCRI.dao.ClienteDAO;
import com.melquisedeque.easyCRI.entity.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteDAO repo;
	
	
	public List<Cliente> findAll() {
		List<Cliente> obj = repo.findAll();
		
		return obj;
	}
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElse(null);
	}
	
	public Cliente findByCpf(String cpf) {
		
		Cliente obj = repo.findByCpf(cpf);
		
		return obj;
	}
	
	public Cliente findByNome(String nome) {
		
		Cliente obj = repo.findByNome(nome);
		
		return obj;
	}

}