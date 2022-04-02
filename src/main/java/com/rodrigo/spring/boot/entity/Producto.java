package com.rodrigo.spring.boot.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data // @AllArgsConstructor //constructor
@NoArgsConstructor // constructor sin parametros
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "precio")
	private BigDecimal precio;
	@Column(name = "stock")
	private Long stock;
	@Column(name = "fecha_creacion")
	private LocalDate fecha_creacion;
	private String URLimagen;

	@PrePersist
	public void preGuardar() {
		this.fecha_creacion = LocalDate.now();
	}

	public Producto(String descripcion, BigDecimal precio, Long stock, String URLimagen) {
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.URLimagen = URLimagen;
	}

	/*
	 * // al usar lombok @data dejaria de usar los metodos get y set de esta manera,
	 * obtengo un codigo mas limpio public Long getId() { return id; } public void
	 * setId(Long id) { this.id = id; } public String getDescripcion() { return
	 * descripcion; } public void setDescripcion(String descripcion) {
	 * this.descripcion = descripcion; } public BigDecimal getPrecio() { return
	 * precio; } public void setPrecio(BigDecimal precio) { this.precio = precio; }
	 * public Long getStock() { return stock; } public void setStock(Long stock) {
	 * this.stock = stock; }
	 */

}
