package com.melquisedeque.easyCRI.services;

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
	
	/*
	 * Metodos GET
	 */
	
	//Pesquisa todos os clientes
	public List<Cliente> findAll() {
		final List<Cliente> obj = repo.findAll();
		
		return obj;
	}
	
	//Pesquisa clientes por ID
	public Cliente findById(final Integer id) throws ObjectNotFoundException{
		
		final Optional<Cliente> obj = repo.findById(id);
		
		
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id:"+ id + ",Tipo: " + Cliente.class.getName()));
	}
	
	//Pesquisa Clientes por CPF
	public Cliente findByCpf(final String cpf) throws ObjectNotFoundException {
		
		final Optional<Cliente> obj = repo.findByCpf(cpf);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! CPF:"+ cpf + ",Tipo: " + Cliente.class.getName()));
	}
	
	//Pesquisa Clientes por nome
	public Cliente findByNome(final String nome) throws ObjectNotFoundException {
		
		final Optional<Cliente> obj = repo.findByNome(nome);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Nome:"+ nome + ",Tipo: " + Cliente.class.getName()));
	}
	
	/*
	 * Metodo POST
	 */
	
	//Insere novo Cliente
	//tentando tratar erro do CPF
	public void insertCliente(final Cliente obj) throws ConstraintViolationException, DataIntegrityViolationException {
	
		try {
			
			obj.setId(null);
			repo.save(obj);
		} catch (final ConstraintViolationException e) {
			throw new ConstraintViolationException("Cliente não adicionado, CPF inválido", null);
		} catch (final DataIntegrityViolationException e){
			throw new DataIntegrityViolationException("Cliente não cadastrado");
		}
	}
}