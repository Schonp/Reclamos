package com.reclamos.reclamos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reclamos.reclamos.enums.EstadoReclamo;
import com.reclamos.reclamos.enums.TipoReclamo;
import com.reclamos.reclamos.model.Sitio;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "reclamo")
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReclamo;

    @ManyToOne
    @JoinColumn(name = "sitio_id")
    @JsonIgnoreProperties("reclamos")
    private Sitio sitio;

    private String descripcion;

    @Enumerated(EnumType.STRING)
    private TipoReclamo tipoReclamo;

    @Enumerated(EnumType.STRING)
    private EstadoReclamo estadoReclamo;

    private String desperfecto;

    @Lob
    private byte[] fotos;

    @ManyToOne(optional = true)
    @JoinColumn(name = "vecino_id", nullable = true)
    @JsonIgnoreProperties("reclamos")
    private Vecino vecino;

    @ManyToOne(optional = true)
    @JoinColumn(name = "inspector_id", nullable = true)
    @JsonIgnoreProperties("reclamos")
    private Inspector inspector;


    public Reclamo(Long idReclamo, Sitio sitio, String descripcion, TipoReclamo tipoReclamo, EstadoReclamo estadoReclamo, String desperfecto, byte[] fotos, Vecino vecino, Inspector inspector) {
        this.idReclamo = idReclamo;
        this.sitio = sitio;
        this.descripcion = descripcion;
        this.tipoReclamo = tipoReclamo;
        this.estadoReclamo = estadoReclamo;
        this.desperfecto = desperfecto;
        this.fotos = fotos;
        this.vecino = vecino;
        this.inspector = inspector;
    }

    public Reclamo() {

    }


    public Long getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(Long idReclamo) {
        this.idReclamo = idReclamo;
    }

    public Sitio getSitio() {
        return sitio;
    }

    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoReclamo getTipoReclamo() {
        return tipoReclamo;
    }

    public void setTipoReclamo(TipoReclamo tipoReclamo) {
        this.tipoReclamo = tipoReclamo;
    }

    public EstadoReclamo getEstadoReclamo() {
        return estadoReclamo;
    }

    public void setEstadoReclamo(EstadoReclamo estadoReclamo) {
        this.estadoReclamo = estadoReclamo;
    }

    public String getDesperfecto() {
        return desperfecto;
    }

    public void setDesperfecto(String desperfecto) {
        this.desperfecto = desperfecto;
    }

    public byte[] getFotos() {
        return fotos;
    }

    public void setFotos(byte[] fotos) {
        this.fotos = fotos;
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
