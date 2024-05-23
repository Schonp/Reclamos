package com.reclamos.reclamos.model.denuncia;

import com.reclamos.reclamos.model.Inspector;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.*;

@Entity
@Table(name = "denuncia_veci_ins")
public class DenunciaVeciIns extends DenunciaVecino{

    @ManyToOne
    @JoinColumn(name = "inspector_id")
    private Inspector denunciante;

    public Inspector getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(Inspector denunciante) {
        this.denunciante = denunciante;
    }
}
