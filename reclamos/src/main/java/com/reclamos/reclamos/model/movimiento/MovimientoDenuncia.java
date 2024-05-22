package com.reclamos.reclamos.model.movimiento;

import com.reclamos.reclamos.enums.TipoMovimiento;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Movimiento")
public class MovimientoDenuncia extends Movimiento {
    @Id
    private int idMovimiento;

    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipoMovimiento;

    private String responsable;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private String causa;
    private int idMovido;
}