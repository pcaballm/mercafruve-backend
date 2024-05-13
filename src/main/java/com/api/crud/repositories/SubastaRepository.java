package com.api.crud.repositories;

import com.api.crud.models.Producto;
import com.api.crud.models.Subasta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubastaRepository extends JpaRepository<Subasta, Integer> {
    Optional<Subasta> findByNombre(String nombre);
    Optional<Subasta> findById(Long id);

    List<Subasta> findAllByProductor(String productor);
}
