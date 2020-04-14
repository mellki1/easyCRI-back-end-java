package com.melquisedeque.easyCRI.controller;

import java.util.ArrayList;
import java.util.List;

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

@RestController
@RequestMapping(value="/clientes")
public class ClienteResourse {

	@Autowired
	private ClienteService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Cliente> obj = service.findAll();

		return ResponseEntity.ok().body(obj); 
	}
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		
		Cliente obj = service.find(id);
		
		return ResponseEntity.ok().body(obj); 
	}
	
	@RequestMapping(value="/cpf/{cpf}", method = RequestMethod.GET)
	public ResponseEntity<?> findByCpf(@PathVariable String cpf) {
		
		
		Cliente obj = service.findByCpf(cpf);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<?> findByNome(@PathVariable String nome) {
		
		
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
	public ResponseEntity<?> registerCliente(@RequestBody Cliente cli){
		
		Cliente obj = service.registerCliente(cli);
		return ResponseEntity.ok().body("registro do cliente " +obj.getNome()+" foi efetuado com sucesso");
		
	}
	
	

	
}