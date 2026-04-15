package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Cliente;
import com.empresa.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Cliente insertaCliente(Cliente objCliente) {
		return clienteRepository.save(objCliente);
	}

	@Override
	public List<Cliente> listaClientePorNombre(String filtro) {
		return clienteRepository.findByNombreContaining(filtro);
	}
	
}
