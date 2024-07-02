package com.reclamos.reclamos.services;

import com.reclamos.reclamos.model.Inspector;
import com.reclamos.reclamos.model.Vecino;
import com.reclamos.reclamos.repositorios.InspectorRepository;
import com.reclamos.reclamos.repositorios.VecinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private VecinoRepository vecinoRepository;

    @Autowired
    private InspectorRepository inspectorRepository;

    public String login(Long id, String password) {
        Vecino vecino = vecinoRepository.findByDocumentoAndPassword(id, password);
        if (vecino != null) {
            return "VECINO";
        }

        Inspector inspector = inspectorRepository.findByLegajoAndPassword(id, password);
        if (inspector != null) {
            return "INSPECTOR";
        }

        return "INVALID";
    }
}
