package com.digitalers.spring.boot.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ProductoResquestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty
	@Size(min = 3, max = 50)
	private String descripcion;

	@Min(value = 0)
	private BigDecimal precio;

	@Min(value = 0)
	private Long stock;

	private String nombreImagen;
}
