package com.melquisedeque.easyCRI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.melquisedeque.easyCRI.dao.TituloDAO;
import com.melquisedeque.easyCRI.entity.enums.Titulo;

@Controller
public class TituloService {

	@Autowired
	private TituloDAO repo;
	
	public List<Titulo> findAll() {
		List<Titulo> obj = repo.findAll();
		
		return obj;
	}
	
	public Titulo find(Integer id) {
		
		Optional<Titulo> obj = repo.findById(id);
		
		return obj.orElse(null);
	}
}
