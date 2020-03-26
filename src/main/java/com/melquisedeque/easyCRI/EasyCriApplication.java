package com.melquisedeque.easyCRI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.melquisedeque.easyCRI.dao.ClienteDAO;
import com.melquisedeque.easyCRI.dao.RequerimentoDAO;
import com.melquisedeque.easyCRI.entity.Cliente;
import com.melquisedeque.easyCRI.entity.Requerimento;
import com.melquisedeque.easyCRI.entity.enums.Titulo;

@SpringBootApplication
public class EasyCriApplication implements CommandLineRunner{

	@Autowired
	private ClienteDAO clienteDAO; 
	@Autowired
	private RequerimentoDAO requerimentoDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(EasyCriApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		// TODO Auto-generated method stub
		Cliente cli1 = new Cliente(null, "Melquisedeque Marcolino da Silva", "brasileira", "solteiro", "escrevente autorizado", "9.413.624", "SDS", "PE", "137.544.106-01", "Wellington Marcolino da Silva", "Angela Valentim da Silva", "Avenida Sao Paulo, nº.537, Santa Vitória-MG", "melki2011@gmail.com", "34 99885-6554");
		Cliente cli2 = new Cliente(null, "Angela Valentim da Silva", "brasileira", "casada", "técnica em química", "MG-1.557.558", "PC", "MG", "763.029.114-00", "Joé Valentim da Silva", 		"Antonia Valentim da Silva", "Avenida Reinaldo Franco de Morais, nº.1175, Santa Vitória-MG", "angela-silva@hotmail.com", "34 99990-9670");
	
		clienteDAO.save(cli1);
		clienteDAO.save(cli2);
		
		Requerimento req1 = new Requerimento(null, "29-02-2000", "O registro da cédula nº.40/03877-88", Titulo.CEDULA);
		Requerimento req2 = new Requerimento(null, "29-03-2020", "A averbação do aditivo nº.40/7778-888", Titulo.ADITIVO);
		Requerimento req3 = new Requerimento(null, "26-03-2020", "A averbação do Baixa", Titulo.BAIXA);
		Requerimento req4 = new Requerimento(null, "29-03-2020", "Da escritura lavrada", Titulo.ESCRITURA);
		
		req1.setCliente(cli1);
		req2.setCliente(cli1);
		req3.setCliente(cli2);
		req4.setCliente(cli2);
		
		requerimentoDAO.save(req1);
		requerimentoDAO.save(req2);
		requerimentoDAO.save(req3);
		requerimentoDAO.save(req4);
		
	}

}
