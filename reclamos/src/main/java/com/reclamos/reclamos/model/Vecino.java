package com.reclamos.reclamos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vecino")
public class Vecino extends Persona{
    @Id
    private int documento;
    private String nombre;
    private String apellido;
    private String direccion;

}
