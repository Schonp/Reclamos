package com.reclamos.reclamos.model;

import com.reclamos.reclamos.enums.EstadoReclamo;
import com.reclamos.reclamos.enums.TipoReclamo;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Reclamo")
public class Reclamo {
    @Id
    private int idReclamo;
    private int idReclamante;
    private int idSitio;
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private TipoReclamo tipoReclamo;

    @Enumerated (EnumType.STRING)
    private EstadoReclamo estadoReclamo;

    private String desperfecto;

    private byte[] fotos;
}
