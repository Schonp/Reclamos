package com.reclamos.reclamos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Persistence;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "Inspector")
public class Inspector extends Persona {
    @Id
    private int legajo;
    private String nombre;
    private String apellido;
    private int documento;
    private String password;
    private int idRubro;
    private Date fechaIngreso;
}
