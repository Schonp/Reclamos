package com.reclamos.reclamos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reclamos.reclamos.enums.TipoSitio;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "sitio")
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
    @JoinColumn(name = "propietario_documento", nullable = true)
    @JsonIgnoreProperties({"sitios", "notificaciones"})
    private Vecino propietario;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp apertura;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp cierre;

    @Enumerated(EnumType.STRING)
    private TipoSitio tipo;

    @OneToMany(mappedBy = "sitio")
    @JsonBackReference
    private List<Promocion> promociones;

    @OneToMany(mappedBy = "sitioDenunciado")
    @JsonBackReference
    private List<Denuncia> denuncias;

    @OneToMany(mappedBy = "sitio")
    @JsonBackReference
    private List<Reclamo> reclamos;



    public Sitio(Long idSitio, String latitud, String altitud, String direccion, String entreCalleA, String entreCalleB, String descripcion, Vecino propietario, Timestamp apertura, Timestamp cierre, TipoSitio tipo, List<Promocion> promociones, List<Denuncia> denuncias, List<Reclamo> reclamos) {
        this.idSitio = idSitio;
        this.latitud = latitud;
        this.altitud = altitud;
        this.direccion = direccion;
        this.entreCalleA = entreCalleA;
        this.entreCalleB = entreCalleB;
        this.descripcion = descripcion;
        this.propietario = propietario;
        this.apertura = apertura;
        this.cierre = cierre;
        this.tipo = tipo;
        this.promociones = promociones;
        this.denuncias = denuncias;
        this.reclamos = reclamos;
    }

    public Sitio() {

    }


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

    public List<Denuncia> getDenuncias() {
        return denuncias;
    }

    public void setDenuncias(List<Denuncia> denuncias) {
        this.denuncias = denuncias;
    }

    public List<Reclamo> getReclamos() {
        return reclamos;
    }

    public void setReclamos(List<Reclamo> reclamos) {
        this.reclamos = reclamos;
    }
}