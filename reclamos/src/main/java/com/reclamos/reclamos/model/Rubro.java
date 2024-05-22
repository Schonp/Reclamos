package com.reclamos.reclamos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Rubro")
public class Rubro {
    @Id
    private int idRubro;
    private String descripcion;
}
