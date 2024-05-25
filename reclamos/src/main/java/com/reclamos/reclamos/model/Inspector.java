package com.reclamos.reclamos.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Inspector")
public class Inspector {

    @Id
    private int legajo;
    private String nombre;
    private String apellido;
    private int documento;
    private String password;

    @ManyToOne
    @JoinColumn(name = "rubro_id")
    private Rubro rubro;
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @OneToMany(mappedBy = "denunciante", cascade = CascadeType.ALL)
    private List<DenunciaVeciIns> denunciasHechas;





    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
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

    public List<DenunciaVeciIns> getDenunciasHechas() {
        return denunciasHechas;
    }

    public void setDenunciasHechas(List<DenunciaVeciIns> denunciasHechas) {
        this.denunciasHechas = denunciasHechas;
    }

    public List<DenunciaSitioIns> getDenunciasSitioHechas() {
        return denunciasSitioHechas;
    }

    public void setDenunciasSitioHechas(List<DenunciaSitioIns> denunciasSitioHechas) {
        this.denunciasSitioHechas = denunciasSitioHechas;
    }
}
