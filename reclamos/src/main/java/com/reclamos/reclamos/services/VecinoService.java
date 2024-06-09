package com.reclamos.reclamos.services;
import com.reclamos.reclamos.model.Vecino;
import com.reclamos.reclamos.repositorios.VecinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VecinoService {
    @Autowired
    private VecinoRepository vecinoRepository;

    public List<Vecino> getAllVecinos() {
        return vecinoRepository.findAll();
    }

    public Vecino getVecinoById(int documento) {
        return vecinoRepository.findById((long) documento).orElse(null);
    }

    public Vecino createVecino(Vecino vecino) {
        return vecinoRepository.save(vecino);
    }

    public Vecino updateVecino(int documento, Vecino vecino) {
        if (vecinoRepository.existsById((long) documento)) {
            vecino.setDocumento((long) documento);
            return vecinoRepository.save(vecino);
        }
        return null;
    }

    public void deleteVecino(int documento) {
        vecinoRepository.deleteById((long) documento);
    }
}

