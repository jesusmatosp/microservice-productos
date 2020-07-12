package com.jmpit.microservices.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jmpit.microservices.model.entity.Producto;
import com.jmpit.microservices.model.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private ProductoRepository repository;
	
	@Override
	@Transactional( readOnly = true )
	public List<Producto> findAll() {
		return (List<Producto>) repository.findAll();
	}

	@Override
	@Transactional( readOnly = true )
	public Producto findById(Long id) {
		return repository.findById(id).orElse(null);
	}

}
