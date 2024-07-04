package com.reclamos.reclamos.repositorios;

import com.reclamos.reclamos.model.Reclamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReclamoRepository extends JpaRepository<Reclamo, Long> {
    List<Reclamo> findByInspectorLegajo(Long inspectorLegajo);
    List<Reclamo> findByVecinoDocumento(Long vecinoDocumento);
}
