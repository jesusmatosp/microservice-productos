package com.jmpit.microservices.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.jmpit.microservices.model.entity.Producto;
import com.jmpit.microservices.model.service.IProductoService;

@RestController
public class ProductoController {

	@Autowired
	private Environment env;
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> listar() {
		return productoService.findAll().stream().map( producto -> {
			producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return producto;
		}).collect(Collectors.toList());
	}	
	
	@GetMapping("/{id}")
	public Producto detalle(@PathVariable("id") Long id) { //throws Exception {
		Producto producto = productoService.findById(id);
		producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		
		// Error:
//		boolean ok = false;
//		if(ok == false)
//			throw new Exception("No se pudo cargar el producto");
//		try {
//			Thread.sleep(2000L);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return producto;
	}
	
}
