package com.reclamos.reclamos.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Vecino")
public class Vecino {
    @Id
    private int documento;
    private String nombre;
    private String apellido;
    private String direccion;

    @OneToMany(mappedBy = "vecino")
    private List<Notificacion> notificaciones;

    @OneToMany(mappedBy = "denunciante", cascade = CascadeType.ALL)
    private List<Denuncia> denunciasHechas;

    @OneToMany(mappedBy = "denunciado", cascade = CascadeType.ALL)
    private List<Denuncia> denunciasRecibidas;

    @OneToOne(mappedBy = "propietario")
    private Sitio sitio;

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
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

    public List<DenunciaVeciVeci> getDenunciasHechas() {
        return denunciasHechas;
    }

    public void setDenunciasHechas(List<DenunciaVeciVeci> denunciasHechas) {
        this.denunciasHechas = denunciasHechas;
    }

    public List<DenunciaVeciVeci> getDenunciasRecibidas() {
        return denunciasRecibidas;
    }

    public void setDenunciasRecibidas(List<DenunciaVeciVeci> denunciasRecibidas) {
        this.denunciasRecibidas = denunciasRecibidas;
    }

    public List<DenunciaSitioVeci> getDenunciasSitioHechas() {
        return denunciasSitioHechas;
    }

    public void setDenunciasSitioHechas(List<DenunciaSitioVeci> denunciasSitioHechas) {
        this.denunciasSitioHechas = denunciasSitioHechas;
    }

    public Sitio getSitio() {
        return sitio;
    }

    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
    }
}
