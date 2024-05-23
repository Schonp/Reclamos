package com.reclamos.reclamos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Notificacion")

public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotificacion;
    private String descripcion;

    // Relacion con Vecino (Opcional dependiendo de uso)
    @ManyToOne
    @JoinColumn(name = "vecino_documento", referencedColumnName = "documento", insertable = false, updatable = false)
    private Vecino vecino;

    // Relacion con Inspector (Opcional dependiendo de uso)
    @ManyToOne
    @JoinColumn(name = "inspector_legajo", referencedColumnName = "legajo", insertable = false, updatable = false)
    private Inspector inspector;

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
