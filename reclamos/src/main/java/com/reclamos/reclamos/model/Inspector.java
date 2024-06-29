package com.reclamos.reclamos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "inspector")
public class Inspector {
    @Id
    private Long legajo;
    private String nombre;
    private String apellido;
    private int documento;
    private String password;

    @ManyToOne
    @JoinColumn(name = "rubro_id")
    @JsonIgnoreProperties("inspectores")
    private Rubro rubro;

    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    @OneToMany(mappedBy = "inspector")
    @JsonManagedReference
    private List<Denuncia> denunciasRecibidas;

    @OneToMany(mappedBy = "inspector")
    @JsonIgnoreProperties("inspector")
    private List<Notificacion> notificaciones;

    @OneToMany(mappedBy = "inspector")
    @JsonManagedReference
    private List<Reclamo> reclamos;


    public Inspector(Long legajo, String nombre, String apellido, int documento, String password, Rubro rubro, Date fechaIngreso, List<Denuncia> denunciasInspeccionadas, List<Notificacion> notificaciones, List<Reclamo> reclamos) {

        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.password = password;
        this.rubro = rubro;
        this.fechaIngreso = fechaIngreso;
        this.denunciasRecibidas = denunciasRecibidas;
        this.notificaciones = notificaciones;
        this.reclamos = reclamos;
    }

    public Inspector() {

    }

    public Long getLegajo() {
        return legajo;
    }

    public void setLegajo(Long legajo) {
        this.legajo = legajo;
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

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public List<Denuncia> getDenunciasRecibidas() {
        return denunciasRecibidas;
    }

    public void setDenunciasRecibidas(List<Denuncia> denunciasRecibidas) {
        this.denunciasRecibidas = denunciasRecibidas;
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public List<Reclamo> getReclamos() {
        return reclamos;
    }

    public void setReclamos(List<Reclamo> reclamos) {
        this.reclamos = reclamos;
    }
}
