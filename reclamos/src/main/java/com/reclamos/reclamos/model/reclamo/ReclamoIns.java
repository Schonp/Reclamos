package com.reclamos.reclamos.model.reclamo;

import com.reclamos.reclamos.model.Inspector;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ReclamoIns extends Reclamo{

    @ManyToOne
    @JoinColumn(name = "inspector_id")
    private Inspector inspector;

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }
}
