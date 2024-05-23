package com.reclamos.reclamos.model.reclamo;

import com.reclamos.reclamos.model.Vecino;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ReclamoVeci extends Reclamo {

    @ManyToOne
    @JoinColumn(name = "denunciante_id")
    private Vecino vecino;

    public Vecino getVecino() {
        return vecino;
    }

    public void setVecino(Vecino vecino) {
        this.vecino = vecino;
    }
}
