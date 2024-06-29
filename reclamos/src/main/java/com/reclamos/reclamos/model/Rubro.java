package com.reclamos.reclamos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rubro")
public class Rubro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRubro;

    private String descripcion;

    @OneToMany(mappedBy = "rubro")
    @JsonIgnoreProperties("rubro")
    private List<Inspector> inspectores;

    @OneToMany(mappedBy = "rubro")
    @JsonIgnoreProperties("rubro")
    private List<Promocion> promociones;


    public Rubro(Long idRubro, String descripcion, List<Inspector> inspectores, List<Promocion> promociones) {
        this.idRubro = idRubro;
        this.descripcion = descripcion;
        this.inspectores = inspectores;
        this.promociones = promociones;
    }

    public Rubro() {

    }


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
