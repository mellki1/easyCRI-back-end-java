package com.melquisedeque.easyCRI.controller;

import java.util.List;


import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.melquisedeque.easyCRI.entity.Cliente;
import com.melquisedeque.easyCRI.services.ClienteService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResourse {

	@Autowired
	private ClienteService service;
	
	
	//Metodos GET
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Cliente> obj = service.findAll();

		return ResponseEntity.ok().body(obj); 
	}
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException {

		
		Cliente obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj); 
	}
	
	@RequestMapping(value="/cpf/{cpf}", method = RequestMethod.GET)
	public ResponseEntity<?> findByCpf(@PathVariable String cpf) throws ObjectNotFoundException {
		return ResponseEntity.ok().body(service.findByCpf(cpf));
	}
	
	@RequestMapping(value="/nome")
	@ResponseBody
	public ResponseEntity<?> findByNome(@RequestParam(value="nome") String nome) {
		return ResponseEntity.ok().body(service.findByNome(nome));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Cliente> registerCliente(@RequestBody Cliente cli) throws ConstraintViolationException, UnexpectedTypeException{
		return ResponseEntity.ok(service.insertCliente(cli));
	}
}