package com.reclamos.reclamos.model.denuncia;

import com.reclamos.reclamos.model.Inspector;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.*;

@Entity
public class DenunciaVeciIns extends DenunciaVecino{

    @ManyToOne
    @JoinColumn(name = "inspector_id")
    private Inspector inspector;
}
