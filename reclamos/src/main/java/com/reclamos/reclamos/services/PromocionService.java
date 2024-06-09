package com.reclamos.reclamos.services;
import com.reclamos.reclamos.model.Promocion;
import com.reclamos.reclamos.repositorios.PromocionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PromocionService {
    @Autowired
    private PromocionRepository promocionRepository;

    public List<Promocion> getAllPromociones() {
        return promocionRepository.findAll();
    }

    public Promocion getPromocionById(Long id) {
        return promocionRepository.findById(id).orElse(null);
    }

    public Promocion createPromocion(Promocion promocion) {
        return promocionRepository.save(promocion);
    }

    public Promocion updatePromocion(Long id, Promocion promocion) {
        if (promocionRepository.existsById(id)) {
            promocion.setIdPromocion(id);
            return promocionRepository.save(promocion);
        }
        return null;
    }

    public void deletePromocion(Long id) {
        promocionRepository.deleteById(id);
    }
}
