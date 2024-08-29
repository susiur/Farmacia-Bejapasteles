package com.proyecto.farmacia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyecto.farmacia.modelentity.Compra;

@Repository
public interface ICompraDAO extends JpaRepository<Compra, Long>{
    // Aquí se pueden agregar métodos adicionales
    @Query("SELECT c FROM Compra c WHERE c.cliente.id = :clienteId")
    public List<Compra> findByCliente_id(Long clienteId);
    

}
