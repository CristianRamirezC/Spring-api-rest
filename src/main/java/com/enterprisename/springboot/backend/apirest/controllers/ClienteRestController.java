package com.enterprisename.springboot.backend.apirest.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.enterprisename.springboot.backend.apirest.models.entity.Cliente;
import com.enterprisename.springboot.backend.apirest.models.services.IClienteService;

@CrossOrigin(origins = {"http://localhost:4200"})  // notacion para el CORS (Cross-Origin Resource Sharing)
@RestController
@RequestMapping("/api") //URL ("Endpoint")
public class ClienteRestController {
	
	@Autowired  //inyeccion de dependencias
	private IClienteService clienteService;
	
	//READ
	@GetMapping("/clientes") //Mapear URL o Endpoint  //verbo GET http
	public List<Cliente> index(){
		return clienteService.FindAll();
	}
	//READ by ID
	@GetMapping("/clientes/{id}")  //verbo GET http
	public Cliente show(@PathVariable Long id) {
		return clienteService.findById(id);
	}
	//CREATE
	@PostMapping("/clientes")  // Verbo POST para crear nuevo contenido
	@ResponseStatus(HttpStatus.CREATED) //configuramos para que el http status sea 201.created en vez de 200.ok cuando la creacion del cliente es successfull
	public Cliente create(@RequestBody Cliente cliente) { //anotacion requestBody para mapear json a objeto cliente
		return clienteService.save(cliente);
	}
	//UPDATE
	@PutMapping("/clientes/{id}") //verbo PUT para actualizar
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
		Cliente clienteActual = clienteService.findById(id);
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setEmail(cliente.getEmail());
		
		return clienteService.save(clienteActual);
	}
	//DELETE
	@DeleteMapping("/clientes/{id}") //Verbo DELETE para eliminar 
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.delete(id);
	}
	
}
