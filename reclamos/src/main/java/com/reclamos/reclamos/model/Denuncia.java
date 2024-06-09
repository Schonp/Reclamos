package com.reclamos.reclamos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reclamos.reclamos.enums.EstadoDenuncia;
import com.reclamos.reclamos.enums.TipoDenuncia;
import com.reclamos.reclamos.model.Vecino;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "denuncia")
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_denuncia")
    private Long idDenuncia;

    private String descripcion;

    @Enumerated(EnumType.STRING)
    private EstadoDenuncia estadoDenuncia;

    @Enumerated(EnumType.STRING)
    private TipoDenuncia tipoDenuncia;

    private String titulo;
    private String causa;
    private String lugar;

    @ManyToOne(optional = true)
    @JoinColumn(name = "sitio_id", nullable = true)
    private Sitio sitioDenunciado;

    @ManyToOne(optional = true)
    @JoinColumn(name = "denunciado_id", nullable = true)
    private Vecino denunciado;

    @ManyToOne(optional = true)
    @JoinColumn(name = "denunciante_id", nullable = true)
    private Vecino denunciante;

    @ManyToOne(optional = true)
    @JoinColumn(name = "inspector_id", nullable = true)
    private Inspector inspector;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private LocalDateTime fechaHora;

    @Lob
    private byte[] pruebas;

    public Denuncia(Long idDenuncia, String descripcion, EstadoDenuncia estadoDenuncia, TipoDenuncia tipoDenuncia, String titulo, String causa, String lugar, Sitio sitioDenunciado, Vecino denunciado, Vecino denunciante, Inspector inspector, LocalDateTime fechaHora, byte[] pruebas) {

        this.idDenuncia = idDenuncia;
        this.descripcion = descripcion;
        this.estadoDenuncia = estadoDenuncia;
        this.tipoDenuncia = tipoDenuncia;
        this.titulo = titulo;
        this.causa = causa;
        this.lugar = lugar;
        this.sitioDenunciado = sitioDenunciado;
        this.denunciado = denunciado;
        this.denunciante = denunciante;
        this.inspector = inspector;
        this.fechaHora = fechaHora;
        this.pruebas = pruebas;
    }

    public Denuncia() {

    }

    public Long getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(Long idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoDenuncia getEstadoDenuncia() {
        return estadoDenuncia;
    }

    public void setEstadoDenuncia(EstadoDenuncia estadoDenuncia) {
        this.estadoDenuncia = estadoDenuncia;
    }

    public TipoDenuncia getTipoDenuncia() {
        return tipoDenuncia;
    }

    public void setTipoDenuncia(TipoDenuncia tipoDenuncia) {
        this.tipoDenuncia = tipoDenuncia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Sitio getSitioDenunciado() {
        return sitioDenunciado;
    }

    public void setSitioDenunciado(Sitio sitioDenunciado) {
        this.sitioDenunciado = sitioDenunciado;
    }

    public Vecino getDenunciado() {
        return denunciado;
    }

    public void setDenunciado(Vecino denunciado) {
        this.denunciado = denunciado;
    }

    public Vecino getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(Vecino denunciante) {
        this.denunciante = denunciante;
    }

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public byte[] getPruebas() {
        return pruebas;
    }

    public void setPruebas(byte[] pruebas) {
        this.pruebas = pruebas;
    }
}
