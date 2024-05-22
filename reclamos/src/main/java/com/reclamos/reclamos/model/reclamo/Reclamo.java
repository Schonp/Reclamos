package com.reclamos.reclamos.model.reclamo;

import com.reclamos.reclamos.enums.EstadoReclamo;
import com.reclamos.reclamos.enums.TipoReclamo;
import com.reclamos.reclamos.model.Sitio;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Reclamo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Reclamo {
    @Id
    private Long idReclamo;
    @ManyToOne
    @JoinColumn(name = "sitio_id")
    private Sitio sitio;
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private TipoReclamo tipoReclamo;

    @Enumerated (EnumType.STRING)
    private EstadoReclamo estadoReclamo;

    private String desperfecto;

    private byte[] fotos;
}
