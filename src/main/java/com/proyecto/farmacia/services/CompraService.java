package com.proyecto.farmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.farmacia.dao.ICompraDAO;
import com.proyecto.farmacia.dao.IProductoDAO;
import com.proyecto.farmacia.modelentity.Compra;
import com.proyecto.farmacia.modelentity.Producto;

import jakarta.transaction.Transactional;

@Service
public class CompraService implements iCompraService{

    @Autowired
    private ICompraDAO compraDAO;

    @Autowired
    private IProductoDAO productoDAO;

    @Autowired
    private ProductoService productoService;

    // @Override
    // public Compra registrarCompra(Compra compra) {
    //     return compraDAO.save(compra);
    // }

    public Compra get(Long id) {
        return compraDAO.findById(id).orElse(null);
    }

    @Override
    public List<Compra> obtenerHistorialComprasCliente(Long clienteId) {
        return compraDAO.findByCliente_id(clienteId);
    }

    public void delete(Long id) {
        compraDAO.deleteById(id);
    }

    public void update(Compra compra) {
        if (compraDAO.existsById(compra.getId())) {
            compraDAO.save(compra);
        } else {
            throw new RuntimeException("Compra no encontrada");
        }
    }
    @Override
    @Transactional
    public Compra registrarCompra(Compra compra) {
        Long prodId = compra.getProducto().getId();
        Producto producto=productoService.get(prodId);
        if (producto.getStock() < compra.getCantidad()) {
            throw new IllegalArgumentException("No hay suficiente stock disponible.");
        }

        // Disminuir stock
        producto.setStock(producto.getStock() - compra.getCantidad());
        productoDAO.save(producto);

        return compraDAO.save(compra);
    }
}