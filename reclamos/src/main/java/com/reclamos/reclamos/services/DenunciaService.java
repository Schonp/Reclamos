package com.reclamos.reclamos.services;

import com.reclamos.reclamos.model.Denuncia;
import com.reclamos.reclamos.enums.EstadoDenuncia;
import com.reclamos.reclamos.model.Inspector;
import com.reclamos.reclamos.model.Sitio;
import com.reclamos.reclamos.enums.TipoDenuncia;
import com.reclamos.reclamos.model.Vecino;
import com.reclamos.reclamos.repositorios.DenunciaRepository;
import com.reclamos.reclamos.repositorios.InspectorRepository;
import com.reclamos.reclamos.repositorios.SitioRepository;
import com.reclamos.reclamos.repositorios.VecinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository denunciaRepository;

    @Autowired
    private SitioRepository sitioRepository;

    @Autowired
    private VecinoRepository vecinoRepository;

    @Autowired
    private InspectorRepository inspectorRepository;

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

    public void saveDenuncia(String descripcion, EstadoDenuncia estadoDenuncia, TipoDenuncia tipoDenuncia, String titulo, String causa, String lugar, Long sitioId, Long denunciadoId, Long denuncianteId, Long inspectorId, MultipartFile file) throws IOException {
        Denuncia denuncia = new Denuncia();
        denuncia.setDescripcion(descripcion);
        denuncia.setEstadoDenuncia(estadoDenuncia);
        denuncia.setTipoDenuncia(tipoDenuncia);
        denuncia.setTitulo(titulo);
        denuncia.setCausa(causa);
        denuncia.setLugar(lugar);

        if (sitioId != null) {
            Sitio sitio = sitioRepository.findById(sitioId).orElse(null);
            denuncia.setSitioDenunciado(sitio);
        }

        if (denunciadoId != null) {
            Vecino denunciado = vecinoRepository.findById(denunciadoId).orElse(null);
            denuncia.setDenunciado(denunciado);
        }

        if (denuncianteId != null) {
            Vecino denunciante = vecinoRepository.findById(denuncianteId).orElse(null);
            denuncia.setDenunciante(denunciante);
        }

        if (inspectorId != null) {
            Inspector inspector = inspectorRepository.findById(inspectorId).orElse(null);
            denuncia.setInspector(inspector);
        }

        if (file != null && !file.isEmpty()) {
            byte[] pruebas = file.getBytes();
            denuncia.setPruebas(pruebas);
        }

        denunciaRepository.save(denuncia);
    }
}
