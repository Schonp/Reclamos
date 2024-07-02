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
    private String email;
    private String password;

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


    public Vecino(Long documento, String apellido, String nombre, String direccion, String email, List<Notificacion> notificaciones, String password, List<Denuncia> denunciasHechas, List<Denuncia> denunciasRecibidas, Sitio sitio, List<Reclamo> reclamos, List<Promocion> promociones) {
        this.documento = documento;
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.notificaciones = notificaciones;
        this.password = password;
        this.denunciasHechas = denunciasHechas;
        this.denunciasRecibidas = denunciasRecibidas;
        this.sitio = sitio;
        this.reclamos = reclamos;
        this.promociones = promociones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Promocion> getPromociones() {
        return promociones;
    }

    public void setPromociones(List<Promocion> promociones) {
        this.promociones = promociones;
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
