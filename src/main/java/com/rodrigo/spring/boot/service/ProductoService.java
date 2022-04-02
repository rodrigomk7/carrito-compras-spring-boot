package com.rodrigo.spring.boot.service;

import java.util.List;

import com.digitalers.spring.boot.dto.ProductoResponseDTO;
import com.digitalers.spring.boot.dto.ProductoResquestDTO;
import com.rodrigo.spring.boot.entity.Producto;

public interface ProductoService {

	List<Producto> listarTodos();

	public ProductoResponseDTO insertar(ProductoResquestDTO dto);
}
