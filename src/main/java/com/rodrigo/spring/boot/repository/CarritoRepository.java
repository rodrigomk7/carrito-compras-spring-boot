package com.rodrigo.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigo.spring.boot.entity.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {

}
