package com.api.crud.models;

import jakarta.persistence.*;


@Entity
@Table(name = "subasta_accion")
public class SubastaAccion {

    @Id
    private Long id;
    private Double pujaActual;

    private String ultimoPujante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPujaActual() {
        return pujaActual;
    }

    public void setPujaActual(Double pujaActual) {
        this.pujaActual = pujaActual;
    }

    public String getUltimoPujante() {
        return ultimoPujante;
    }

    public void setUltimoPujante(String ultimoPujante) {
        this.ultimoPujante = ultimoPujante;
    }
}
