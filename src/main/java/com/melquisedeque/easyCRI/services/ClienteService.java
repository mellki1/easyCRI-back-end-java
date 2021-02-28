package com.melquisedeque.easyCRI.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import com.melquisedeque.easyCRI.dao.ClienteDAO;
import com.melquisedeque.easyCRI.entity.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteDAO repo;
	

	public List<Cliente> findAll() {
		final List<Cliente> obj = repo.findAll();
		return obj;
	}

	public Cliente findById(final Integer id) throws ObjectNotFoundException{
		final Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id:"+ id + ",Tipo: " + Cliente.class.getName()));
	}

	public Cliente findByCpf(String cpf) throws ObjectNotFoundException {
		if (!cpf.contains(".") || !cpf.contains("-")){
			cpf = cpf.replace(".","");
			cpf = cpf.replace("-","");
			cpf = cpf.substring(0,3).concat(".") + cpf.substring(3,6).concat(".") + cpf.substring(6,9).concat("-") + cpf.substring(9,11);
		}
		Optional<Cliente> obj = repo.findByCpf(cpf);
		String finalCpf = cpf;
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Cliente não encontrado! CPF:"+ finalCpf + ",Tipo: " + Cliente.class.getName()
		));
	}

	public List<Cliente> findByNome(final String nome) {
		List<Cliente> sugestoes = new ArrayList<>();
		List<Cliente> allClientes = this.findAll();
		for(Cliente cliente : allClientes) {
			if(cliente.getNome().contains(nome)) {
				sugestoes.add(cliente);
			}
		}
		return sugestoes;
	}

	public Cliente insertCliente(final Cliente obj) throws ConstraintViolationException, DataIntegrityViolationException {
		try {
			return repo.save(obj);
		} catch (ConstraintViolationException e) {
			throw new ConstraintViolationException("Cliente não adicionado, CPF inválido", null);
		} catch (DataIntegrityViolationException e){
			throw new DataIntegrityViolationException("Cliente não cadastrado");
		}
	}
}