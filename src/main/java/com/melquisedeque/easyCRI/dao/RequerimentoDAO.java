package com.melquisedeque.easyCRI.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melquisedeque.easyCRI.entity.Requerimento;

@Repository
public interface RequerimentoDAO extends JpaRepository<Requerimento, Integer>{

	List<Requerimento> findAll();
	//Optional<Requerimento> findByidTipoRequerimento();
	

}
