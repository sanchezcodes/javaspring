package org.luisalbertocodes.crud.repository;

import org.luisalbertocodes.crud.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    List<Cliente> findAll();
    Cliente findById(Long id);
    void save(Cliente cliente);
    void update(Cliente cliente);
    void delete(Long id);
    Optional<Cliente> findByNombreAndApellido(String nombre, String apellido);
}

