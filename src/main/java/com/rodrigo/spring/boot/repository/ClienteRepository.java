package com.rodrigo.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo.spring.boot.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
