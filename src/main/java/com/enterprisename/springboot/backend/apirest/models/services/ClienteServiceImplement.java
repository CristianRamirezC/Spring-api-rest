package com.enterprisename.springboot.backend.apirest.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.enterprisename.springboot.backend.apirest.models.dao.IClienteDao;
import com.enterprisename.springboot.backend.apirest.models.entity.Cliente;

//CRUD
@Service
public class ClienteServiceImplement implements IClienteService{

	@Autowired  //notación para inyección de dependencias
	private IClienteDao clientedDao; //objeto DAO con funciones CRUD (CRUD Repository)
	
	@Override
	@Transactional(readOnly = true) // manejar transacciones en el metodo
	public List<Cliente> FindAll() {		
		return (List<Cliente>) clientedDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clientedDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clientedDao.save(cliente);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		clientedDao.deleteById(id);
	}
}
