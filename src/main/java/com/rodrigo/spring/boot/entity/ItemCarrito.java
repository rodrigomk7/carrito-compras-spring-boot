package com.rodrigo.spring.boot.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "carrito_items")
@Data
@AllArgsConstructor
public class ItemCarrito implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// private Long id;
	private Integer cantidad;

	// hago la relacion entre producto y el item
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_id") // nombre de la columna
	private Producto producto;

	// metodo para calcular el importe del item carrito
	public BigDecimal getImporte() {
		// BigDecimal importe =
		// this.producto.getPrecio().multiply(BigDecimal.valueOf(this.cantidad));

		return this.producto.getPrecio().multiply(BigDecimal.valueOf(this.cantidad));
	}

}
