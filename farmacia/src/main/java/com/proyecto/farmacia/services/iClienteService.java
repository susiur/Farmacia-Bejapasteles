package com.proyecto.farmacia.services;

import java.util.List;

import com.proyecto.farmacia.modelentity.Cliente;

public interface iClienteService {
// save, get, update, delete
    public List<Cliente> findAll();
    public Cliente get(Long id);
    public void delete(Long id);
    public Cliente save(Cliente cliente);
    public void update(Cliente cliente);
}