package com.melquisedeque.easyCRI.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		
		
		Cliente obj = service.findByCpf(cpf);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<?> findByNome(@PathVariable String nome) throws ObjectNotFoundException {
		
		
		Cliente obj = service.findByNome(nome);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/nome")
	@ResponseBody
	public ResponseEntity<?> clientesNomesAutocomplete(@RequestParam(value="term", required=false, defaultValue="") String term){
		List<String> sugestoes = new ArrayList<String>();
		List<Cliente> allClientes = service.findAll();
		for(Cliente clientes : allClientes) {
			if(clientes.getNome().contains(term)) {
				sugestoes.add(clientes.getNome());	
			}
			
		}
		return ResponseEntity.ok().body(sugestoes);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> registerCliente(@RequestBody Cliente cli) throws javax.validation.ConstraintViolationException{
	
		
		service.insertCliente(cli);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cli.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	

	
}