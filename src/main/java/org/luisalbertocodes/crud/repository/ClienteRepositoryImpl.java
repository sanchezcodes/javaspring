package org.luisalbertocodes.crud.repository;

import org.luisalbertocodes.crud.model.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cliente> findAll() {
        TypedQuery<Cliente> query = entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class);
        return query.getResultList();
    }

    @Override
    public Cliente findById(Long id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        entityManager.persist(cliente);
    }

    @Override
    @Transactional
    public void update(Cliente cliente) {
        entityManager.merge(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Cliente cliente = findById(id);
        if (cliente != null) {
            entityManager.remove(cliente);
        }
    }

    @Override
    public Optional<Cliente> findByNombreAndApellido(String nombre, String apellido) {
        TypedQuery<Cliente> query = entityManager.createQuery(
                "SELECT c FROM Cliente c WHERE c.nombre = :nombre AND c.apellido = :apellido",
                Cliente.class);
        query.setParameter("nombre", nombre);
        query.setParameter("apellido", apellido);

        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
