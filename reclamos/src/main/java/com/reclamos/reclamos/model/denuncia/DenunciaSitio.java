package com.reclamos.reclamos.model.denuncia;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reclamos.reclamos.model.Sitio;
import jakarta.persistence.*;

@Entity
@Table(name = "Denuncia")
public class DenunciaSitio extends Denuncia {

    @ManyToOne
    @JoinColumn(name = "sitio_id")
    @JsonIgnore
    private Sitio sitio;


}