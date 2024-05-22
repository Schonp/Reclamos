package com.reclamos.reclamos.model.denuncia;

import com.reclamos.reclamos.model.Inspector;
import jakarta.persistence.*;

@Entity
public class DenunciaSitioIns extends DenunciaSitio{

    @ManyToOne
    @JoinColumn(name = "inspector_id")
    private Inspector inspector;
}
