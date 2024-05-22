package com.reclamos.reclamos.model;

import com.reclamos.reclamos.enums.EstadoPromocion;
import com.reclamos.reclamos.enums.TipoPromocion;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "Promocion")
public class Promocion {
    @Id
    private int idPromocion;

    @Enumerated(EnumType.STRING)
    private TipoPromocion tipoPromocion;

    private int idSitio;
    private int idRubro;
    private byte[] fotos;
    private String descripcion; 
    private String titulo; 
    private String horarios; 
    private String direccion;
    private String contacto;
    private int idVecino;

    @Enumerated (EnumType.STRING)
    private EstadoPromocion estadoPromocion;
}
