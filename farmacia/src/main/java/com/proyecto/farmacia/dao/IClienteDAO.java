package com.proyecto.farmacia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.farmacia.modelentity.Cliente;

@Repository
public interface IClienteDAO extends JpaRepository<Cliente, Long>{
    // Aquí se pueden agregar métodos adicionales
    public Cliente findByEmail(String email);
}
