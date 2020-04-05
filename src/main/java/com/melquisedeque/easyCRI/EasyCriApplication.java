package com.melquisedeque.easyCRI;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.melquisedeque.easyCRI.dao.ClienteDAO;
import com.melquisedeque.easyCRI.dao.RequerimentoDAO;
import com.melquisedeque.easyCRI.dao.TituloDAO;
import com.melquisedeque.easyCRI.entity.Cliente;
import com.melquisedeque.easyCRI.entity.Requerimento;
import com.melquisedeque.easyCRI.entity.Titulo;

@SpringBootApplication
public class EasyCriApplication implements CommandLineRunner{

	@Autowired
	private ClienteDAO clienteDAO; 
	
	@Autowired
	private RequerimentoDAO requerimentoDAO;
	
	@Autowired
	private TituloDAO tituloDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(EasyCriApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		// TODO Auto-generated method stub
		Cliente cli1 = new Cliente(null, "Melquisedeque Marcolino da Silva", "brasileira", "solteiro", "escrevente autorizado", "9.413.624", "SDS", "PE", "137.544.106-01", "Wellington Marcolino da Silva", "Angela Valentim da Silva", "Avenida Sao Paulo, nº.537, Santa Vitória-MG", "melki2011@gmail.com", "34 99885-6554");
		Cliente cli2 = new Cliente(null, "Angela Valentim da Silva", "brasileira", "casada", "técnica em química", "MG-1.557.558", "PC", "MG", "763.029.114-00", "Joé Valentim da Silva", 		"Antonia Valentim da Silva", "Avenida Reinaldo Franco de Morais, nº.1175, Santa Vitória-MG", "angela-silva@hotmail.com", "34 99990-9670");
	
		clienteDAO.saveAll(Arrays.asList(cli1, cli2));
		
		Titulo titulo1 = new Titulo(null, "Escritura");
		Titulo titulo2 = new Titulo(null, "Aditivo");
		Titulo titulo3 = new Titulo(null, "Cédula");
		Titulo titulo4 = new Titulo(null, "Requerimento");
		
		tituloDAO.saveAll(Arrays.asList(titulo1, titulo2, titulo3, titulo4));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		
		
		Requerimento req1 = new Requerimento(null, sdf.parse("27-02-2009"), "O registro da cédula nº.40/03877-88");
		Requerimento req2 = new Requerimento(null, sdf.parse("29-03-2020"), "A averbação do aditivo nº.40/7778-888");
		Requerimento req3 = new Requerimento(null, sdf.parse("26-03-2020"), "A averbação do Baixa");
		Requerimento req4 = new Requerimento(null, sdf.parse("29-03-2020"), "Da escritura lavrada");
		
		
		req1.setCliente(cli1);
		req2.setCliente(cli1);
		req3.setCliente(cli2);
		req4.setCliente(cli2);
		
		req1.setTitulo(titulo1);
		req2.setTitulo(titulo2);
		req3.setTitulo(titulo3);
		req4.setTitulo(titulo4);
		
		requerimentoDAO.saveAll(Arrays.asList(req1, req2, req3, req4));

	}

}
