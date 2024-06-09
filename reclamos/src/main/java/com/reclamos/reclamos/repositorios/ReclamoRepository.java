package com.reclamos.reclamos.repositorios;

import com.reclamos.reclamos.model.Reclamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclamoRepository extends JpaRepository<Reclamo, Long> {}
