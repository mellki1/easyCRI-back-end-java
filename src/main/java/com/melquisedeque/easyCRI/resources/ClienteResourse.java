package com.melquisedeque.easyCRI.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.melquisedeque.easyCRI.domain.Cliente;
import com.melquisedeque.easyCRI.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResourse {

	@Autowired
	private ClienteService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		
		Cliente obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj); 
	}
	/*
	@RequestMapping(value="/{cpf}", method = RequestMethod.GET)
	public ResponseEntity<?> findcpf(@PathVariable String cpf) {
		
		
		Cliente obj = service.buscarCpf(cpf);
		
		return ResponseEntity.ok().body(obj);
	}*/
}
