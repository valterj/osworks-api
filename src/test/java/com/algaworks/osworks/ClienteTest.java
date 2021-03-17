package com.algaworks.osworks;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.algaworks.osworks.domain.model.Cliente;

public class ClienteTest {
	
	ClienteRepositoryMock clienteRepositoryMock = new ClienteRepositoryMock();
	
	@Test
	public void aoCriarUmCliente() throws Exception {
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		cliente.setNome("Valter");
		cliente.setTelefone("99911-9911");
		cliente.setEmail("valterz@gmail.com");
		
		Cliente novoCliente = this.clienteRepositoryMock.save(cliente);
		
		assertEquals(cliente, novoCliente);		
	}
	
	static class ClienteRepositoryMock {
		
		List<Cliente> clientes = new ArrayList<Cliente>();

		public Cliente save(Cliente cliente) {
			this.clientes.add(cliente);
			return cliente;
		}
		
	}

}
