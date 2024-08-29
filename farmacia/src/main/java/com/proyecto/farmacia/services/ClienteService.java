package com.proyecto.farmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.farmacia.dao.IClienteDAO;
import com.proyecto.farmacia.modelentity.Cliente;

@Service
public class ClienteService implements iClienteService {
    @Autowired
    private IClienteDAO clienteDAO;

    @Override
    public List<Cliente> findAll() {
        return clienteDAO.findAll();
    }

    @Override
    public Cliente get(Long id) {
        return clienteDAO.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        clienteDAO.deleteById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        System.out.println(cliente);
        return clienteDAO.save(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        if (clienteDAO.existsById(cliente.getId())) {
            clienteDAO.save(cliente);
        } else {
            throw new RuntimeException("Cliente no encontrado");
        }
}


}
