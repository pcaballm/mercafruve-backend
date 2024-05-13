package com.api.crud.services;

import com.api.crud.models.Producto;
import com.api.crud.models.Subasta;
import com.api.crud.repositories.ProductoRepository;
import com.api.crud.repositories.SubastaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubastaService {

    @Autowired
    SubastaRepository subastaRepository;
    public void save(Subasta subasta) {

        if (subastaRepository.findByNombre(subasta.getNombre()).isPresent()) {
            throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "Existe una subasta con el mismo nombre.");
        }
        subastaRepository.save(subasta);
    }

    public void delete(Integer id) {

        Optional<Subasta> subasta = subastaRepository.findById(id);
        if (subasta.isEmpty()) {
            throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "No existe una subasta con ese identificador.");
        }
        subastaRepository.delete(subasta.get());
    }

    public void update(Subasta subasta) {
        if (subastaRepository.findById(subasta.getId()) == null) {
            throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "No existe una subasta con ese identificador.");
        }
        subastaRepository.save(subasta);
    }

    public List<Subasta> findAll() {
        return subastaRepository.findAll();
    }

    public List<Subasta> findAllByProductor(String productor) {
        return subastaRepository.findAllByProductor(productor);
    }

    public Subasta findById(Long id) {

        Optional<Subasta> subasta = subastaRepository.findById(id);
        if (subasta.isEmpty()) {
            throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "No existe una subasta con ese identificador.");

        }
        return subasta.get();
    }

    public Subasta findByNombre(String nombre) {

        Optional<Subasta> subasta = subastaRepository.findByNombre(nombre);
        if (subasta.isEmpty()) {
            throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "No existe una subasta con ese nombre.");

        }
        return subasta.get();
    }
}
