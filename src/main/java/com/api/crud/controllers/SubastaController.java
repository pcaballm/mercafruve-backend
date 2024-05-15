package com.api.crud.controllers;

import com.api.crud.models.LogSubasta;
import com.api.crud.models.Subasta;
import com.api.crud.models.SubastaAccion;
import com.api.crud.services.LogSubastaService;
import com.api.crud.services.SubastaAccionService;
import com.api.crud.services.SubastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/subasta")
@CrossOrigin
public class SubastaController {

    @Autowired
    SubastaService subastaService;

    @Autowired
    SubastaAccionService subastaAccionService;

    @Autowired
    LogSubastaService logSubastaService;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestParam String nombre, @RequestParam String descripcion, @RequestParam String producto,
                                   @RequestParam String productor, @RequestParam Integer cantidad, @RequestParam Double precioSalida, @RequestParam Double pujaMinima,
                                   @RequestParam LocalDateTime fechaHoraLimite, @RequestParam LocalDateTime fechaHoraInicio) {

        Subasta subasta = new Subasta();
        subasta.setNombre(nombre);
        subasta.setDescripcion(descripcion);
        subasta.setProducto(producto);
        subasta.setProductor(productor);
        subasta.setCantidad(cantidad);
        subasta.setPrecioSalida(precioSalida);
        subasta.setPujaMinima(pujaMinima);
        subasta.setFechaHoraLimite(fechaHoraLimite);
        subasta.setFechaHoraInicio(fechaHoraInicio);

        Subasta sub = subastaService.save(subasta);

        SubastaAccion subastaAccion = new SubastaAccion();
        subastaAccion.setId(sub.getId());
        subastaAccion.setPujaActual(sub.getPrecioSalida());
        subastaAccionService.save(subastaAccion);

        return new ResponseEntity<>("Producto guardado.", HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editar(@RequestParam String nombre, @RequestParam String descripcion, @RequestParam String producto,
                                   @RequestParam String productor, @RequestParam Integer cantidad, @RequestParam Double precioSalida, @RequestParam Double pujaMinima,
                                   @RequestParam LocalDateTime fechaHoraLimite, @RequestParam LocalDateTime fechaHoraInicio) {

        Subasta subasta = subastaService.findByNombre(nombre);
        subasta.setNombre(nombre);
        subasta.setDescripcion(descripcion);
        subasta.setProducto(producto);
        subasta.setProductor(productor);
        subasta.setCantidad(cantidad);
        subasta.setPrecioSalida(precioSalida);
        subasta.setPujaMinima(pujaMinima);
        subasta.setFechaHoraLimite(fechaHoraLimite);
        subasta.setFechaHoraInicio(fechaHoraInicio);

        subastaService.update(subasta);
        return new ResponseEntity<>("Producto guardado.", HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar")
    public ResponseEntity<?> borrar(@RequestParam Integer id) {
        subastaService.delete(id);

        return new ResponseEntity<>("Producto eliminado.", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/obtenerTodos")
    public ResponseEntity<List<Subasta>> obtenerTodos() {
        return new ResponseEntity<>(subastaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/obtener")
    public ResponseEntity<Subasta> obtener(@RequestParam Long id) {
        Subasta subastaConsultada = subastaService.findById(id);

        return new ResponseEntity<>(subastaConsultada, HttpStatus.OK);
    }

    @PutMapping("/subastaAccion/puja")
    public ResponseEntity<SubastaAccion> editar(@RequestParam Long id, @RequestParam String usuario, @RequestParam Double puja, @RequestParam LocalDateTime fechaHora) {
        SubastaAccion subastaAccion = subastaAccionService.findById(id);

        if (!usuario.isEmpty()) {
            subastaAccion.setUltimoPujante(usuario);
        }
        subastaAccion.setPujaActual(puja);
        subastaAccion = subastaAccionService.save(subastaAccion);

        LogSubasta logSubasta = new LogSubasta();
        logSubasta.setUsuario(usuario);
        logSubasta.setSubasta(id);
        logSubasta.setPuja(puja);
        logSubasta.setFechaHoraPuja(fechaHora);
        logSubastaService.save(logSubasta);

        return new ResponseEntity<>(subastaAccion, HttpStatus.OK);
    }

    @GetMapping("/obtener/subastaAccion")
    public ResponseEntity<SubastaAccion> obtenerSubastaAccion(@RequestParam Long id) {
        return new ResponseEntity<>(subastaAccionService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/obtenerTodos/logSubasta")
    public ResponseEntity<List<LogSubasta>> obtenerTodosLogSubasta() {
        return new ResponseEntity<>(logSubastaService.findAll(), HttpStatus.OK);
    }

}
