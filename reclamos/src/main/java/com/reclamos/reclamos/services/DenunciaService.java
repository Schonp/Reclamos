package com.reclamos.reclamos.services;
import com.reclamos.reclamos.model.Denuncia;
import com.reclamos.reclamos.repositorios.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository denunciaRepository;

    public List<Denuncia> getAllDenuncias() {
        return denunciaRepository.findAll();
    }

    public Denuncia getDenunciaById(Long id) {
        return denunciaRepository.findById(id).orElse(null);
    }

    public Denuncia createDenuncia(Denuncia denuncia) {
        return denunciaRepository.save(denuncia);
    }

    public Denuncia updateDenuncia(Long id, Denuncia denuncia) {
        if (denunciaRepository.existsById(id)) {
            denuncia.setIdDenuncia(id);
            return denunciaRepository.save(denuncia);
        }
        return null;
    }

    public void deleteDenuncia(Long id) {
        denunciaRepository.deleteById(id);
    }
}
