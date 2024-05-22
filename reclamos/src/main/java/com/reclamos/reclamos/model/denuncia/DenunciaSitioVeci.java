package com.reclamos.reclamos.model.denuncia;

import com.reclamos.reclamos.model.Vecino;
import jakarta.persistence.*;

@Entity
public class DenunciaSitioVeci extends DenunciaSitio{

    @ManyToOne
    @JoinColumn(name = "denunciante_id")
    private Vecino vecino;
}
