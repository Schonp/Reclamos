package com.reclamos.reclamos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Notificacion")

public class Notificacion {
    @Id
    private int idNotificacion;
    private int idUsuario;
    private String descripcion;
}
