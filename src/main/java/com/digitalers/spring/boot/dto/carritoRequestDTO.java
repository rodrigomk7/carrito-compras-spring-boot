package com.digitalers.spring.boot.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class carritoRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descripcion;
	private String observacion;
	private Long IdCliente;
	private List<itemCarritoDTO> items;

}
