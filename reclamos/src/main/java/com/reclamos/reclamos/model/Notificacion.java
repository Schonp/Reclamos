package com.reclamos.reclamos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "notificacion")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotificacion;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "vecino_documento", referencedColumnName = "documento")
    @JsonBackReference
    private Vecino vecino;

    @ManyToOne
    @JoinColumn(name = "inspector_legajo", referencedColumnName = "legajo")
    @JsonBackReference
    private Inspector inspector;


    public Notificacion(Long idNotificacion, String descripcion, Vecino vecino, Inspector inspector) {
        this.idNotificacion = idNotificacion;
        this.descripcion = descripcion;
        this.vecino = vecino;
        this.inspector = inspector;
    }

    public Notificacion() {

    }

    public Long getIdNotificacion() {

        return idNotificacion;
    }

    public void setIdNotificacion(Long idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Vecino getVecino() {
        return vecino;
    }

    public void setVecino(Vecino vecino) {
        this.vecino = vecino;
    }

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }
}
