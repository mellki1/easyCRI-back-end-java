package com.melquisedeque.easyCRI.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.melquisedeque.easyCRI.entity.Requerimento;
import com.melquisedeque.easyCRI.services.RequerimentoService;

@RestController
@RequestMapping(value = "/requerimentos")
public class RequerimentoResourse {
	
	@Autowired
	private RequerimentoService service;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		
		List<Requerimento> obj = service.findAll();
		
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		
		Requerimento obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj); 
	}
	
	@RequestMapping(value="/data")
	@ResponseBody
	public ResponseEntity<?> findByData(@RequestParam(value="date", required=false, defaultValue="") String date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		Date data_formatada = sdf.parse(date);
		
		System.out.println(date);
		List<Requerimento> obj = service.findByData(data_formatada);
		
		return ResponseEntity.ok().body(obj);
	}
	/*
	@RequestMapping(value = "/descricao")
	@ResponseBody
	public ResponseEntity<?> tiposDeAtoAutocomplete(@RequestParam(value="term", required=false, defaultValue="") String descricao){
		List<String> sugestoes = new ArrayList<String>();
		List<Titulo> todosTiposAtos = Arrays.asList(Titulo.values());
		for(Titulo titulo : todosTiposAtos) {
			sugestoes.add(titulo.getNome());
		}
		return ResponseEntity.ok().body(sugestoes);
		
	}
	*/
	
}