package org.luisalbertocodes.crud.service;

import org.luisalbertocodes.crud.exception.ResourceNotFoundException;
import org.luisalbertocodes.crud.model.Cliente;
import org.luisalbertocodes.crud.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        Cliente cliente = clienteRepository.findById(id);
        if (cliente == null) {
            throw new ResourceNotFoundException("Cliente no encontrado con id: " + id);
        }
        return cliente;
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public void update(Cliente cliente) {
        clienteRepository.update(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteRepository.delete(id);
    }
}