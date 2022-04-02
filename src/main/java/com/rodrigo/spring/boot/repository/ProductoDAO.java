package com.rodrigo.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigo.spring.boot.entity.Producto;

@Repository
public interface ProductoDAO extends JpaRepository<Producto, Long>{
	//aqui van los metodos personalizados
	
	//hacer una query para obtener los productos en stock
	
	
}
