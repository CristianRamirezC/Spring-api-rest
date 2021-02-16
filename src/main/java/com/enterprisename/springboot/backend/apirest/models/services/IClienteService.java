package com.enterprisename.springboot.backend.apirest.models.services;

import java.util.*;
import com.enterprisename.springboot.backend.apirest.models.entity.Cliente;


public interface IClienteService {
	
	public List<Cliente> FindAll();
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);

}
