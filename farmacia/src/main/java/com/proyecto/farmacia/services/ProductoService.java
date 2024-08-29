package com.proyecto.farmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.farmacia.dao.IProductoDAO;
import com.proyecto.farmacia.modelentity.Producto;

@Service
public class ProductoService implements iProductoService {
    @Autowired
    private IProductoDAO productoDAO;

    @Override
    public List<Producto> findAll() {
        return productoDAO.findAll();
    }

    @Override
    public Producto get(Long id) {
        return productoDAO.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        productoDAO.deleteById(id);
    }

    @Override
    public Producto save(Producto producto) {
        System.out.println(producto);
        return productoDAO.save(producto);
    }

    @Override
    public void update(Producto producto) {
        productoDAO.save(producto);

    }
}
