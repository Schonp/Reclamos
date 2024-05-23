package com.reclamos.reclamos.model;

import com.reclamos.reclamos.enums.TipoSitio;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Sitio")
public class Sitio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSitio;
    private String latitud;
    private String altitud;
    private String direccion;
    private String entreCalleA;
    private String entreCalleB;
    private String descripcion;
    @OneToOne
    @JoinColumn(name = "propietario_documento")
    private Vecino propietario;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp apertura;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp cierre;
    @Enumerated(EnumType.STRING)
    private TipoSitio tipo;

    @OneToMany(mappedBy = "sitio")
    private List<Promocion> promociones;

    public Long getIdSitio() {
        return idSitio;
    }

    public void setIdSitio(Long idSitio) {
        this.idSitio = idSitio;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getAltitud() {
        return altitud;
    }

    public void setAltitud(String altitud) {
        this.altitud = altitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEntreCalleA() {
        return entreCalleA;
    }

    public void setEntreCalleA(String entreCalleA) {
        this.entreCalleA = entreCalleA;
    }

    public String getEntreCalleB() {
        return entreCalleB;
    }

    public void setEntreCalleB(String entreCalleB) {
        this.entreCalleB = entreCalleB;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Vecino getPropietario() {
        return propietario;
    }

    public void setPropietario(Vecino propietario) {
        this.propietario = propietario;
    }

    public Timestamp getApertura() {
        return apertura;
    }

    public void setApertura(Timestamp apertura) {
        this.apertura = apertura;
    }

    public Timestamp getCierre() {
        return cierre;
    }

    public void setCierre(Timestamp cierre) {
        this.cierre = cierre;
    }

    public TipoSitio getTipo() {
        return tipo;
    }

    public void setTipo(TipoSitio tipo) {
        this.tipo = tipo;
    }

    public List<Promocion> getPromociones() {
        return promociones;
    }

    public void setPromociones(List<Promocion> promociones) {
        this.promociones = promociones;
    }
}
