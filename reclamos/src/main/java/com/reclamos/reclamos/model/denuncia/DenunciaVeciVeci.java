package com.reclamos.reclamos.model.denuncia;

import com.reclamos.reclamos.model.Vecino;
import jakarta.persistence.*;

@Entity
@Table(name = "denuncia_vecino_vecino")
public class DenunciaVeciVeci extends DenunciaVecino{

    @ManyToOne
    @JoinColumn(name = "denunciante_id")
    private Vecino denunciante;

    public Vecino getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(Vecino denunciante) {
        this.denunciante = denunciante;
    }
}
