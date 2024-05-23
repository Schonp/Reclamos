package com.reclamos.reclamos.model.reclamo;

import com.reclamos.reclamos.enums.EstadoReclamo;
import com.reclamos.reclamos.enums.TipoReclamo;
import com.reclamos.reclamos.model.Sitio;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReclamo;
    @ManyToOne
    @JoinColumn(name = "sitio_id")
    private Sitio sitio;
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private TipoReclamo tipoReclamo;

    @Enumerated(EnumType.STRING)
    private EstadoReclamo estadoReclamo;

    private String desperfecto;

    @Lob
    private byte[] fotos;

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
}
