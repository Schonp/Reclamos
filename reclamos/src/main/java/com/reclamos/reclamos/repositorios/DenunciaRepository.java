package com.reclamos.reclamos.repositorios;
import com.reclamos.reclamos.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {
    List<Denuncia> findByDenuncianteDocumento(Long denuncianteDocumento);
}

