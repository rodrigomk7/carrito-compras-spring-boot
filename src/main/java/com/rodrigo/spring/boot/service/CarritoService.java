package com.rodrigo.spring.boot.service;

import com.digitalers.spring.boot.dto.carritoRequestDTO;
import com.rodrigo.spring.boot.entity.Carrito;

public interface CarritoService {

	public Carrito insertar(carritoRequestDTO dto);

}
