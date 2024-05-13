package com.api.crud.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotEmpty
    private String nombre;
    private String descripcion;
    private String imagen;
    @Column(nullable = false)
    private Double precio;
    @Column(nullable = false)
    private String productor;
    @Column(nullable = false)
    private String tipo;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public Double getPrecio() {
        return precio;
    }
    public String getTipo() {
        return tipo;
    }
    public String getProductor() {
        return productor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
