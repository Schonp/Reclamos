package com.reclamos.reclamos.services;
import com.reclamos.reclamos.model.Rubro;
import com.reclamos.reclamos.repositorios.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RubroService {
    @Autowired
    private RubroRepository rubroRepository;

    public List<Rubro> getAllRubros() {
        return rubroRepository.findAll();
    }

    public Rubro getRubroById(Long id) {
        return rubroRepository.findById(id).orElse(null);
    }

    public Rubro createRubro(Rubro rubro) {
        return rubroRepository.save(rubro);
    }

    public Rubro updateRubro(Long id, Rubro rubro) {
        if (rubroRepository.existsById(id)) {
            rubro.setIdRubro(id);
            return rubroRepository.save(rubro);
        }
        return null;
    }

    public void deleteRubro(Long id) {
        rubroRepository.deleteById(id);
    }
}

