package com.empresa.service;

import java.util.List;

import com.empresa.entity.Cliente;

public interface ClienteService {

	
	public abstract Cliente insertaCliente(Cliente objCliente);
	public abstract List<Cliente> listaClientePorNombre(String filtro);
	
}
