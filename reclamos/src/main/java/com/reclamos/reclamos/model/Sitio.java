package com.reclamos.reclamos.model;

import com.reclamos.reclamos.enums.TipoSitio;
import jakarta.persistence.*;

import java.sql.Timestamp;
@Entity
@Table(name = "Sitio")
public class Sitio {
    @Id
    private int idSitio;
    private String latitud;
    private String altitud;
    private String direccion;
    private String entreCalleA;
    private String entreCalleB;
    private String descripcion;
    private int idPropietario;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp apertura;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp cierre;
    private TipoSitio tipo;

}
