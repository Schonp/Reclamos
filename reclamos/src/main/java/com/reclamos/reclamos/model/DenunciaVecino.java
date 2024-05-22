package com.reclamos.reclamos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reclamos.reclamos.enums.EstadoDenuncia;
import com.reclamos.reclamos.enums.TipoDenuncia;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Denuncia")
public class DenunciaVecino extends Denuncia {


    @ManyToOne
    @JoinColumn(name = "vecino_id")
    @JsonIgnore
    private Vecino vecino;


}