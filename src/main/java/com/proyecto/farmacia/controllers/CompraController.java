package com.proyecto.farmacia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.farmacia.modelentity.Compra;
import com.proyecto.farmacia.services.CompraService;


@RestController
@RequestMapping("/api/compras")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<Compra> save(@RequestBody Compra compra) {
        Compra nuevaCompra = compraService.registrarCompra(compra);
        return new ResponseEntity<>(nuevaCompra, HttpStatus.CREATED);
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Iterable<Compra>> obtenerHistorialComprasCliente(@PathVariable Long clienteId) {
        return new ResponseEntity<>(compraService.obtenerHistorialComprasCliente(clienteId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        compraService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Compra> update(@RequestBody Compra compra, @PathVariable Long id) {
        Compra compraExistente = compraService.get(id);
        if (compraExistente != null) {
            compraService.update(compra);
            return new ResponseEntity<>(compra, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
