package com.reclamos.reclamos.model;

import com.reclamos.reclamos.enums.EstadoPromocion;
import com.reclamos.reclamos.enums.TipoPromocion;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "Promocion")
public class Promocion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPromocion;

    @Enumerated(EnumType.STRING)
    private TipoPromocion tipoPromocion;

    @ManyToOne
    @JoinColumn(name = "idSitio", referencedColumnName = "idSitio", insertable = false, updatable = false)
    private Sitio sitio;
    @ManyToOne
    @JoinColumn(name = "idRubro", referencedColumnName = "idRubro", insertable = false, updatable = false)
    private Rubro rubro;
    @Lob
    private byte[] fotos;
    private String descripcion; 
    private String titulo; 
    private String horarios; 
    private String direccion;
    private String contacto;
    @ManyToOne
    @JoinColumn(name = "idVecino", referencedColumnName = "documento", insertable = false, updatable = false)
    private Vecino vecino;

    @Enumerated (EnumType.STRING)
    private EstadoPromocion estadoPromocion;

    public Long getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(Long idPromocion) {
        this.idPromocion = idPromocion;
    }

    public TipoPromocion getTipoPromocion() {
        return tipoPromocion;
    }

    public void setTipoPromocion(TipoPromocion tipoPromocion) {
        this.tipoPromocion = tipoPromocion;
    }

    public Sitio getSitio() {
        return sitio;
    }

    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public byte[] getFotos() {
        return fotos;
    }

    public void setFotos(byte[] fotos) {
        this.fotos = fotos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Vecino getVecino() {
        return vecino;
    }

    public void setVecino(Vecino vecino) {
        this.vecino = vecino;
    }

    public EstadoPromocion getEstadoPromocion() {
        return estadoPromocion;
    }

    public void setEstadoPromocion(EstadoPromocion estadoPromocion) {
        this.estadoPromocion = estadoPromocion;
    }
}
