package com.proyecto.farmacia.services;

import java.util.List;

import com.proyecto.farmacia.modelentity.Producto;

public interface iProductoService {
    // save, get, update, delete
    public List<Producto> findAll();
    public Producto get(Long id);
    public void delete(Long id);
    public Producto save(Producto compra);
    public void update(Producto compra);
    
}
