package com.reclamos.reclamos.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Rubro")
public class Rubro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRubro;
    private String descripcion;

    @OneToMany(mappedBy = "rubro")
    private List<Inspector> inspectores;

    @OneToMany(mappedBy = "rubro")
    private List<Promocion> promociones;

    public Long getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(Long idRubro) {
        this.idRubro = idRubro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Inspector> getInspectores() {
        return inspectores;
    }

    public void setInspectores(List<Inspector> inspectores) {
        this.inspectores = inspectores;
    }

    public List<Promocion> getPromociones() {
        return promociones;
    }

    public void setPromociones(List<Promocion> promociones) {
        this.promociones = promociones;
    }
}
