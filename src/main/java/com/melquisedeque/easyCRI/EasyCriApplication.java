package com.melquisedeque.easyCRI;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.melquisedeque.easyCRI.dao.ClienteDAO;
import com.melquisedeque.easyCRI.dao.RequerimentoDAO;
import com.melquisedeque.easyCRI.entity.Cliente;
import com.melquisedeque.easyCRI.entity.Requerimento;
import com.melquisedeque.easyCRI.entity.enums.TipoAto;

@SpringBootApplication
public class EasyCriApplication implements CommandLineRunner{

	@Autowired
	private ClienteDAO clienteDAO; 
	private RequerimentoDAO requerimentoDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(EasyCriApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Cliente cli1 = new Cliente(null, "Melquisedeque Marcolino da Silva", "brasileira", "solteiro", "escrevente autorizado", "9.413.624", "SDS", "PE", "137.544.106-01", "Wellington Marcolino da Silva", "Angela Valentim da Silva", "Avenida Sao Paulo, nº.537, Santa Vitória-MG", "melki2011@gmail.com", "34 99885-6554");
		Cliente cli2 = new Cliente(null, "Angela Valentim da Silva", "brasileira", "casada", "técnica em química", "MG-1.557.558", "PC", "MG", "763.029.114-00", "Joé Valentim da Silva", 		"Antonia Valentim da Silva", "Avenida Reinaldo Franco de Morais, nº.1175, Santa Vitória-MG", "angela-silva@hotmail.com", "34 99990-9670");
		
		
		Requerimento req1 = new Requerimento(null, cli1, TipoAto.ABERTURA_DE_MATRICULA);
		
		
		//Requerimento req2 = new Requerimento(null, TipoAto.ABERTURA_DE_MATRICULA);
		

		/*Requerimento req3 = new Requerimento(null, cli2, TipoAto.ADITIVO);
		Requerimento req4 = new Requerimento(null, cli1, TipoAto.ALTERACAO_RG);
		Requerimento req5 = new Requerimento(null, cli1, TipoAto.ALTERACAO_CPF);
		Requerimento req6 = new Requerimento(null, cli1, TipoAto.ADITIVO);*/
		//req2, req3, req4, req5, req6
		
		//clienteDAO.saveAll(Arrays.asList(cli1, cli2));
		requerimentoDAO.saveAll(Arrays.asList(req1));
	}

}
