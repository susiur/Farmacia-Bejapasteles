package com.proyecto.farmacia.services;

import java.util.List;

import com.proyecto.farmacia.modelentity.Compra;

public interface iCompraService {
    Compra registrarCompra(Compra compra);
    List<Compra> obtenerHistorialComprasCliente(Long clienteId);
}