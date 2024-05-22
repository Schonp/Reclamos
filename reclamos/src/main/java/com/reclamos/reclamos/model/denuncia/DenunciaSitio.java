package com.reclamos.reclamos.model.denuncia;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reclamos.reclamos.model.Sitio;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class DenunciaSitio extends Denuncia {

    @ManyToOne
    @JoinColumn(name = "sitio_id")
    private Sitio sitio;


}