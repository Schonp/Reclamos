package com.reclamos.reclamos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vecino")
public class Vecino {
    @Id
    private Long documento;

    private String nombre;
    private String apellido;
    private String direccion;

    @OneToMany(mappedBy = "vecino")
    @JsonIgnoreProperties("vecino")
    private List<Notificacion> notificaciones;

    @OneToMany(mappedBy = "denunciante", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Denuncia> denunciasHechas;

    @OneToMany(mappedBy = "denunciado", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Denuncia> denunciasRecibidas;

    @OneToOne(mappedBy = "propietario")
    @JsonIgnoreProperties("propietario")
    private Sitio sitio;

    @OneToMany(mappedBy = "vecino")
    @JsonIgnoreProperties("vecino")
    private List<Reclamo>reclamos;

    @OneToMany(mappedBy = "vecino")
    @JsonIgnoreProperties("vecino")
    private List<Promocion> promociones;



    public Vecino(Long documento, String nombre, String apellido, String direccion, List<Notificacion> notificaciones, List<Denuncia> denunciasHechas, List<Denuncia> denunciasRecibidas, Sitio sitio, List<Reclamo> reclamos) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.notificaciones = notificaciones;
        this.denunciasHechas = denunciasHechas;
        this.denunciasRecibidas = denunciasRecibidas;
        this.sitio = sitio;
        this.reclamos = reclamos;
    }

    public Vecino() {

    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public List<Denuncia> getDenunciasHechas() {
        return denunciasHechas;
    }

    public void setDenunciasHechas(List<Denuncia> denunciasHechas) {
        this.denunciasHechas = denunciasHechas;
    }

    public List<Denuncia> getDenunciasRecibidas() {
        return denunciasRecibidas;
    }

    public void setDenunciasRecibidas(List<Denuncia> denunciasRecibidas) {
        this.denunciasRecibidas = denunciasRecibidas;
    }

    public Sitio getSitio() {
        return sitio;
    }

    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
    }

    public List<Reclamo> getReclamos() {
        return reclamos;
    }

    public void setReclamos(List<Reclamo> reclamos) {
        this.reclamos = reclamos;
    }
}
