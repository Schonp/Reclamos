package com.reclamos.reclamos.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Inspector")
public class Inspector {

    @Id
    private Long legajo;
    private String nombre;
    private String apellido;
    private int documento;
    private String password;

    @ManyToOne
    @JoinColumn(name = "rubro_id")
    private Rubro rubro;

    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    @OneToMany(mappedBy = "inspector", cascade = CascadeType.ALL)
    private List<Denuncia> denunciasInspeccionadas;

    @OneToMany(mappedBy = "inspector")
    private List<Notificacion> notificaciones;

    public Inspector(Long legajo, String nombre, String apellido, int documento, String password, Rubro rubro, Date fechaIngreso, List<Denuncia> denunciasInspeccionadas, List<Notificacion> notificaciones) {

        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.password = password;
        this.rubro = rubro;
        this.fechaIngreso = fechaIngreso;
        this.denunciasInspeccionadas = denunciasInspeccionadas;
        this.notificaciones = notificaciones;
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

    public List<Denuncia> getDenunciasInspeccionadas() {
        return denunciasInspeccionadas;
    }

    public void setDenunciasInspeccionadas(List<Denuncia> denunciasInspeccionadas) {
        this.denunciasInspeccionadas = denunciasInspeccionadas;
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }
}
