package com.reclamos.reclamos.model.denuncia;

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
@Table(name = "Denuncia")
public abstract class Denuncia {
    @Id
    private int idDenuncia;

    @OneToOne
    private Vecino denunciante;

    private String descripcion;

    @Enumerated (EnumType.STRING)
    private EstadoDenuncia estadoDenuncia;

    @Enumerated (EnumType.STRING)
    private TipoDenuncia tipoDenuncia;

    private String titulo;
    private String causa;
    private String lugar;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private LocalDateTime fechaHora;
    private byte[] pruebas;
}
