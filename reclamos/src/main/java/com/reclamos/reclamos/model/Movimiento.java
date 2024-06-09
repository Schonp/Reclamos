package com.reclamos.reclamos.model;

import com.reclamos.reclamos.enums.TipoMovimiento;
import com.reclamos.reclamos.model.Denuncia;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "movimiento")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimiento;

    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipoMovimiento;

    private String responsable;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private String causa;

    @ManyToOne(optional = true)
    @JoinColumn(name = "denuncia_id", nullable = true)
    private Denuncia denuncia;

    @ManyToOne(optional = true)
    @JoinColumn(name = "reclamo_id", nullable = true)
    private Reclamo reclamo;

    public Movimiento(Long idMovimiento, TipoMovimiento tipoMovimiento, String responsable, Date fecha, String causa, Denuncia denuncia, Reclamo reclamo) {
        this.idMovimiento = idMovimiento;
        this.tipoMovimiento = tipoMovimiento;
        this.responsable = responsable;
        this.fecha = fecha;
        this.causa = causa;
        this.denuncia = denuncia;
        this.reclamo = reclamo;
    }

    public Movimiento() {

    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }
}