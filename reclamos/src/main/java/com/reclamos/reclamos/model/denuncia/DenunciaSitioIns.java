package com.reclamos.reclamos.model.denuncia;

import com.reclamos.reclamos.model.Inspector;
import jakarta.persistence.*;

@Entity
@Table(name = "denuncia_sitio_ins")
public class DenunciaSitioIns extends DenunciaSitio{

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
