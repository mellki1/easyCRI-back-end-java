package com.melquisedeque.easyCRI.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.melquisedeque.easyCRI.entity.Requerimento;

public interface RequerimentoDAO extends JpaRepository<Requerimento, Integer>{

	List<Requerimento> findByData(Date data);

	
}
