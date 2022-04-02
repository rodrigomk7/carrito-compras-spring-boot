package com.rodrigo.spring.boot.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalers.spring.boot.dto.carritoRequestDTO;
import com.rodrigo.spring.boot.entity.Carrito;
import com.rodrigo.spring.boot.entity.Cliente;
import com.rodrigo.spring.boot.entity.ItemCarrito;
import com.rodrigo.spring.boot.repository.CarritoRepository;
import com.rodrigo.spring.boot.repository.ClienteRepository;
import com.rodrigo.spring.boot.repository.ProductoDAO;
import com.rodrigo.spring.boot.service.CarritoService;

@Service
public class CarritoServiceImpl implements CarritoService {

	private CarritoRepository carritoDAO;
	private ClienteRepository clienteDAO;
	private ProductoDAO productoDAO;

	@Autowired
	public CarritoServiceImpl(CarritoRepository carritoDAO, ClienteRepository clienteDAO, ProductoDAO productoDAO) {
		this.carritoDAO = carritoDAO;
		this.clienteDAO = clienteDAO;
		this.productoDAO = productoDAO;
	}

	@Override
	@Transactional
	public Carrito insertar(carritoRequestDTO dto) {
		List<ItemCarrito> items = dto.getItems().stream()
				.map(itemCarritoDTO -> new ItemCarrito(itemCarritoDTO.getCantidad(),
						this.productoDAO.getById(itemCarritoDTO.getIdProducto())))
				.collect(Collectors.toList());

		Cliente cli = this.clienteDAO.findById(dto.getIdCliente()).orElseThrow();

		Carrito c = new Carrito(dto.getDescripcion(), dto.getObservacion(), cli, items);
		return this.carritoDAO.save(c);
	}

}
