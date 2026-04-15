package com.empresa.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Cliente;
import com.empresa.service.ClienteService;

@RestController
@RequestMapping("/rest/cliente")
@CrossOrigin("http://localhost:4200")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> insertaCliente(@RequestBody Cliente objCliente){
		HashMap<String, Object> salida = new HashMap<>();
		objCliente.setIdCliente(0);
		objCliente.setFechaRegistro(LocalDateTime.now());
		objCliente.setEstado(1);
		Cliente objSalida = clienteService.insertaCliente(objCliente);
		salida.put("mensaje", "Proveedor registrado");
		salida.put("data", objSalida);
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/listaClientePorNombre")
	public ResponseEntity<?> listaClientePorNombre(@RequestParam String filtro) {
		List<Cliente> lista =  clienteService.listaClientePorNombre(filtro);
		return ResponseEntity.ok(lista);
	}
	
	
}
