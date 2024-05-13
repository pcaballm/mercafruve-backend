package com.api.crud.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

@Entity
@Table(name = "subasta")
public class Subasta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty
    private String nombre;
    private String descripcion;
    @Column(nullable = false)
    private String producto;
    @Column(nullable = false)
    private String productor;
    @Column(nullable = false)
    private Integer cantidad;
    @Column(nullable = false)
    private Double precioSalida;
    @Column(nullable = false)
    private Double pujaMinima;
    @Column(nullable = false)
    private LocalDateTime fechaHoraLimite;
    @Column(nullable = false)
    private LocalDateTime fechaHoraInicio;

    public Long getId() {
        return id;
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

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioSalida() {
        return precioSalida;
    }

    public void setPrecioSalida(Double precioSalida) {
        this.precioSalida = precioSalida;
    }

    public Double getPujaMinima() {
        return pujaMinima;
    }

    public void setPujaMinima(Double pujaMinima) {
        this.pujaMinima = pujaMinima;
    }

    public LocalDateTime getFechaHoraLimite() {
        return fechaHoraLimite;
    }

    public void setFechaHoraLimite(LocalDateTime fechaHoraLimite) {
        this.fechaHoraLimite = fechaHoraLimite;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }
}
