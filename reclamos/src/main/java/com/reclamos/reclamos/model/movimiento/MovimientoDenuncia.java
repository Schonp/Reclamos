package com.reclamos.reclamos.model.movimiento;

import com.reclamos.reclamos.enums.TipoMovimiento;
import com.reclamos.reclamos.model.denuncia.Denuncia;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class MovimientoDenuncia extends Movimiento {

    @ManyToOne
    @JoinColumn(name="denuncia_id")
    private Denuncia denuncia;
}