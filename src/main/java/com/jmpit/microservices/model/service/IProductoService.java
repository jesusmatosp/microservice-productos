package com.jmpit.microservices.model.service;

import java.util.List;

import com.jmpit.microservices.model.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	public Producto findById(Long id);
	
}
