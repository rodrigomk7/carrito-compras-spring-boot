package com.rodrigo.spring.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalers.spring.boot.dto.carritoRequestDTO;
import com.rodrigo.spring.boot.entity.Carrito;
import com.rodrigo.spring.boot.service.CarritoService;

@CrossOrigin(origins = { "http://127.0.0.1:5500/" })
@RestController
@RequestMapping("/carritos")
public class CarritoController {
	// falta poner lo del log

	private CarritoService carritoService;

	@Autowired
	public CarritoController(CarritoService carritoService) {
		this.carritoService = carritoService;
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody carritoRequestDTO dto) {

		Map<String, Object> respuesta = new HashMap<>();

		try {
			Carrito elementoGuardado = this.carritoService.insertar(dto);
			respuesta.put("mensaje", "El producto se guardo correctamente");
			// respuesta.put("elemento", elementoGuardado);

			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
		} catch (Exception e) {
			respuesta.put("mensaje", "Bocurrio un erroe en la app" + e.getMessage());
			respuesta.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		// return null;
	}

}
