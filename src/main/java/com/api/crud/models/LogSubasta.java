package com.api.crud.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "log-subasta")
public class LogSubasta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long subasta;
    private String usuario;
    private Double puja;
    private LocalDateTime fechaHoraPuja;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubasta() {
        return subasta;
    }

    public void setSubasta(Long subasta) {
        this.subasta = subasta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Double getPuja() {
        return puja;
    }

    public void setPuja(Double puja) {
        this.puja = puja;
    }

    public LocalDateTime getFechaHoraPuja() {
        return fechaHoraPuja;
    }

    public void setFechaHoraPuja(LocalDateTime fechaHoraPuja) {
        this.fechaHoraPuja = fechaHoraPuja;
    }
}
