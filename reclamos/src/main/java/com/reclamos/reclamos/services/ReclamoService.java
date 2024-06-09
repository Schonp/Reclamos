package com.reclamos.reclamos.services;
import com.reclamos.reclamos.model.Reclamo;
import com.reclamos.reclamos.repositorios.ReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReclamoService {
    @Autowired
    private ReclamoRepository reclamoRepository;

    public List<Reclamo> getAllReclamos() {
        return reclamoRepository.findAll();
    }

    public Reclamo getReclamoById(Long id) {
        return reclamoRepository.findById(id).orElse(null);
    }

    public Reclamo createReclamo(Reclamo reclamo) {
        return reclamoRepository.save(reclamo);
    }

    public Reclamo updateReclamo(Long id, Reclamo reclamo) {
        if (reclamoRepository.existsById(id)) {
            reclamo.setIdReclamo(id);
            return reclamoRepository.save(reclamo);
        }
        return null;
    }

    public void deleteReclamo(Long id) {
        reclamoRepository.deleteById(id);
    }
}

