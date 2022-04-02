package com.rodrigo.spring.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalers.spring.boot.dto.ProductoResponseDTO;
import com.digitalers.spring.boot.dto.ProductoResquestDTO;
import com.rodrigo.spring.boot.entity.Producto;
import com.rodrigo.spring.boot.repository.ProductoDAO;
import com.rodrigo.spring.boot.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

	private ProductoDAO dao;

	@Autowired
	public ProductoServiceImpl(ProductoDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<Producto> listarTodos() {
		// Producto a = new Producto();
		// a.setDescripcion(null);
		// no me funciona los metodos get y set y otros al usar el lombok (ver)
		return this.dao.findAll();
	}

	@Override
	public ProductoResponseDTO insertar(ProductoResquestDTO dto) {
		Producto producto = new Producto(dto.getDescripcion(), dto.getPrecio(), dto.getStock(), dto.getNombreImagen());
		this.dao.save(producto);
		return new ProductoResponseDTO(producto.getId(), producto.getDescripcion(), producto.getPrecio(),
				producto.getStock(), producto.getFecha_creacion(), producto.getURLimagen());
	}

}
