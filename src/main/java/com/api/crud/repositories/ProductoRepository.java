package com.api.crud.repositories;

import com.api.crud.models.Producto;
import com.api.crud.models.ProductoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    Optional<Producto> findByNombre(String nombre);
    Optional<Producto> findByNombreAndProductor(String nombre, String productor);
    Producto findById(Long id);

}
