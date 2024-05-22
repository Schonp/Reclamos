package com.reclamos.reclamos.model.denuncia;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reclamos.reclamos.model.Vecino;
import jakarta.persistence.*;

@Entity
@Table(name = "Denuncia")
public class DenunciaVecino extends Denuncia {


    @ManyToOne
    @JoinColumn(name = "vecino_id")
    @JsonIgnore
    private Vecino vecino;


}