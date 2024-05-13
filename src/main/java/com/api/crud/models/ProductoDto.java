package com.api.crud.models;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.core.io.Resource;

public class ProductoDto {

    private Long id;
    private String nombre;
    private String descripcion;
    private Resource imagen;
    private Double precio;
    private String productor;
    private String tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Resource getImagen() {
        return imagen;
    }

    public void setImagen(Resource imagen) {
        this.imagen = imagen;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
