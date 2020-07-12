package com.jmpit.microservices.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.jmpit.microservices.model.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

	
	
}
