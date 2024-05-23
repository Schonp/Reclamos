package com.reclamos.reclamos.model.denuncia;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reclamos.reclamos.model.Vecino;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "denuncia_persona")
public class DenunciaVecino extends Denuncia {


    @ManyToOne
    @JoinColumn(name = "vecino_id")
    private Vecino denunciado;

    public Vecino getDenunciado() {
        return denunciado;
    }

    public void setDenunciado(Vecino denunciado) {
        this.denunciado = denunciado;
    }
}