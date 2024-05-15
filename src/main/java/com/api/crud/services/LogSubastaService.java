package com.api.crud.services;

import com.api.crud.models.LogSubasta;
import com.api.crud.repositories.LogSubastaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class LogSubastaService {

    @Autowired
    LogSubastaRepository logSubastaRepository;

    public void save(LogSubasta logSubasta) {
        if (logSubasta == null) {
            throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "El logSubasta está null.");
        }
        logSubastaRepository.save(logSubasta);
    }

    public List<LogSubasta> findAllById(Long id) {
        return logSubastaRepository.findAllBySubasta(id);
    }
}
