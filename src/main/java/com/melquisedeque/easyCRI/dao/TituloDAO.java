package com.melquisedeque.easyCRI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melquisedeque.easyCRI.entity.enums.Titulo;

@Repository
public interface TituloDAO extends JpaRepository<Titulo, Integer>{

}
