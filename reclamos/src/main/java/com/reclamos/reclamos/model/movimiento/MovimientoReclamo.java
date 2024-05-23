package com.reclamos.reclamos.model.movimiento;

import com.reclamos.reclamos.enums.TipoMovimiento;
import com.reclamos.reclamos.model.denuncia.Denuncia;
import com.reclamos.reclamos.model.reclamo.Reclamo;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class MovimientoReclamo extends MovimientoDenuncia {
    @ManyToOne
    @JoinColumn(name="reclamo_id")
    private Reclamo reclamo;

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }
}
