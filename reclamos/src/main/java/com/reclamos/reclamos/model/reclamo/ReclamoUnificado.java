package com.reclamos.reclamos.model.reclamo;

import jakarta.persistence.Entity;

@Entity
public class ReclamoUnificado extends Reclamo  {

    private Long idUnificaco;

    public Long getIdUnificaco() {
        return idUnificaco;
    }

    public void setIdUnificaco(Long idUnificaco) {
        this.idUnificaco = idUnificaco;
    }
}
