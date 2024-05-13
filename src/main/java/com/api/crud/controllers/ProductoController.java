package com.api.crud.controllers;


import com.api.crud.models.Producto;
import com.api.crud.models.ProductoDto;
import com.api.crud.services.ProductoService;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
@CrossOrigin
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestParam String nombre, @RequestParam String descripcion, @RequestParam Double precio,
                                   @RequestParam String productor, @RequestParam String tipo, @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {

        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setProductor(productor);
        producto.setTipo(tipo);

        Optional<Producto> productoConsultado = productoService.findByNombre(nombre);

        if (productoConsultado.isPresent() && productoConsultado.get().getProductor().equals(producto.getProductor())) {
            return new ResponseEntity<>( "El productor ya tiene este producto.", HttpStatus.BAD_REQUEST);
        }
        productoService.save(producto, file);
        return new ResponseEntity<>("Producto guardado.", HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editar(@RequestParam String nombre, @RequestParam String descripcion, @RequestParam Double precio,
                                   @RequestParam String productor, @RequestParam String tipo, @RequestParam(value = "file", required = false)  MultipartFile file) throws Exception {

        Optional<Producto> productoConsultado = productoService.findByNombreAndProductor(nombre, productor);
        if (productoConsultado.isPresent()) {
            Producto producto = productoConsultado.get();
            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);
            producto.setProductor(productor);
            producto.setTipo(tipo);
            productoService.update(producto, file);
        }

        return new ResponseEntity<>("Producto editado.", HttpStatus.OK);
    }

    @DeleteMapping("/borrar")
    public ResponseEntity<?> borrar(@RequestParam Integer id) {
        productoService.delete(id);

        return new ResponseEntity<>("Producto eliminado.", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/obtenerTodos")
    public ResponseEntity<List<Producto>> obtenerTodos() {
        return new ResponseEntity<>(productoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/obtener")
    public ResponseEntity<Producto> obtener(@RequestParam Integer id) {
        Optional<Producto> productoConsultado = productoService.finById(id);
        if (!productoConsultado.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productoConsultado.get(), HttpStatus.OK);
    }
}
