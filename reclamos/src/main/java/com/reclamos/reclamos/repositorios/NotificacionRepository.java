package com.reclamos.reclamos.repositorios;

import com.reclamos.reclamos.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    List<Notificacion> findByVecinoDocumento(Long documento);
    List<Notificacion> findByInspectorLegajo(Long legajo);
}
