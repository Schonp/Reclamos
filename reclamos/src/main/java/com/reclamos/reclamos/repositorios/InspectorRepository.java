package com.reclamos.reclamos.repositorios;

import com.reclamos.reclamos.model.Inspector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectorRepository extends JpaRepository<Inspector, Long> {
    Inspector findByLegajoAndPassword(Long legajo, String password);
}