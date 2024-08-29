package com.proyecto.farmacia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.farmacia.modelentity.Producto;

@Repository 
public interface IProductoDAO extends JpaRepository<Producto, Long>{
    // Aquí se pueden agregar métodos adicionales

}
