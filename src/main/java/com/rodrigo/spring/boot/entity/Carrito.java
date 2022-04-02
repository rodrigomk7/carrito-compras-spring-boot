package com.rodrigo.spring.boot.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "carritos")
@Data
public class Carrito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String descripcion;
	private String observacion;
	@Column(name = "fecha_creacion")
	private LocalDate fecha_creacion;

	// relacion con los item
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "carrito_id")
	private List<ItemCarrito> itemsCarrito;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	// sobrescrivo el constructor para inicializar la lista de items carrito
	public Carrito() {
		this.itemsCarrito = new ArrayList<>();
	}

	public Carrito(String d, String o, Cliente c, List<ItemCarrito> l) {
		this.descripcion = d;
		this.cliente = c;
		this.itemsCarrito = l;
		this.observacion = o;
	}

	@PrePersist
	public void preGuardar() {
		this.fecha_creacion = LocalDate.now();
	}

	// obtener el total de la factura del carrito
	public BigDecimal getTotal() {
		return this.itemsCarrito.stream().map(item -> item.getImporte()).reduce(BigDecimal.ZERO, BigDecimal::add);

	}

}
