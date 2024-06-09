package com.reclamos.reclamos.services;
import com.reclamos.reclamos.model.Sitio;
import com.reclamos.reclamos.repositorios.SitioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SitioService {
    @Autowired
    private SitioRepository sitioRepository;

    public List<Sitio> getAllSitios() {
        return sitioRepository.findAll();
    }

    public Sitio getSitioById(Long id) {
        return sitioRepository.findById(id).orElse(null);
    }

    public Sitio createSitio(Sitio sitio) {
        return sitioRepository.save(sitio);
    }

    public Sitio updateSitio(Long id, Sitio sitio) {
        if (sitioRepository.existsById(id)) {
            sitio.setIdSitio(id);
            return sitioRepository.save(sitio);
        }
        return null;
    }

    public void deleteSitio(Long id) {
        sitioRepository.deleteById(id);
    }
}

