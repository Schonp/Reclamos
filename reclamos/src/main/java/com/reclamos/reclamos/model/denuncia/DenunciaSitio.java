package com.reclamos.reclamos.model.denuncia;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reclamos.reclamos.model.Sitio;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "denuncia_sitio")
public abstract class DenunciaSitio extends Denuncia {

    @ManyToOne
    @JoinColumn(name = "sitio_id")
    private Sitio denunciado;

    public Sitio getDenunciado() {
        return denunciado;
    }

    public void setDenunciado(Sitio denunciado) {
        this.denunciado = denunciado;
    }
}