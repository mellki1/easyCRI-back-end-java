package com.melquisedeque.easyCRI.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.melquisedeque.easyCRI.domain.Cliente;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResourses {

	@RequestMapping(method = RequestMethod.GET)
	public List<Cliente> listar() {

		Cliente cli1 = new Cliente(1 ,"Melquisedeque Marcolino da Silva", "brasileira", "solteiro", "escrevente autorizado", "9.413.624", "SDS", "PE", "137.544.106-01", "Wellington Marcolino da Silva", "Angela Valentim da Silva", "Avenida São Paulo, 537, Centro, Santa Vitória-MG", "melki2011@gmail.com", "34 9988565554");
		
		List<Cliente> listaCliente= new ArrayList<>();
		
		listaCliente.add(cli1);
		return listaCliente;
	}
}
