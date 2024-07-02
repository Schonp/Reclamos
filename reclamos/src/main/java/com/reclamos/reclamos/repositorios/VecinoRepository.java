package com.reclamos.reclamos.repositorios;

import com.reclamos.reclamos.model.Vecino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VecinoRepository extends JpaRepository<Vecino, Long> {
    Vecino findByDocumentoAndPassword(Long documento, String password);
}