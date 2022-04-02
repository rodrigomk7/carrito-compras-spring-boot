package com.digitalers.spring.boot.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String descripcion;
	private BigDecimal precio;
	private Long stock;
	private LocalDate fecha_creacion;
	private String nombreImagen;
}
