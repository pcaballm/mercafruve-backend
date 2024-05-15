package com.api.crud.services;

import com.api.crud.models.SubastaAccion;
import com.api.crud.repositories.SubastaAccionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Optional;

@Service
@Transactional
public class SubastaAccionService {

    @Autowired
    SubastaAccionRepository subastaAccionRepository;

    public SubastaAccion findById(Long id) {
        Optional<SubastaAccion> subastaAccionOptional = subastaAccionRepository.findById(id);
        if (subastaAccionOptional.isEmpty()) {
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND, "No se ha encontrado Subasta Accion con ese id.");
        }
        return subastaAccionOptional.get();
    }

    public SubastaAccion save (SubastaAccion subastaAccion) {
        if (subastaAccion == null) {
            throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "La Subasta Acción proporcionada está vacía.");
        }
        return subastaAccionRepository.save(subastaAccion);
    }
}
