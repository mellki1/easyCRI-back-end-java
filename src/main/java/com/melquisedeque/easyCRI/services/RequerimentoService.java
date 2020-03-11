package com.melquisedeque.easyCRI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melquisedeque.easyCRI.dao.RequerimentoDAO;
import com.melquisedeque.easyCRI.entity.Requerimento;

@Service
public class RequerimentoService {
	
	@Autowired
	private RequerimentoDAO repoRequerimento;
	
	public List<Requerimento> findAll(){
		
		List<Requerimento> obj = repoRequerimento.findAll();
		
		return obj;
	}
	
	public Requerimento findById(Integer id){
		
		Optional<Requerimento> obj = repoRequerimento.findById(id);
		
		return obj.orElse(null);
	}
	
	/*
	public Requerimento findByidTipoRequerimento(Integer id) {
		Optional<Requerimento> obj = repoRequerimento.findByidTipoRequerimento();
		
		return obj.orElse(null);
	}*/
	
}
