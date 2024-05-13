package com.api.crud.controllers;

import com.api.crud.services.FilesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;

@RestController
@RequestMapping("/imagen")
@CrossOrigin


public class ImagenController {

    @Autowired
    FilesServices filesServices;
    @GetMapping("/obtener")
    public ResponseEntity<Resource> obtenerImagen(@RequestParam String nombreImagen) throws MalformedURLException {

        Resource resource = filesServices.obtenerImagen(nombreImagen);

        if (resource.exists()) {
            return new ResponseEntity<>(resource, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
