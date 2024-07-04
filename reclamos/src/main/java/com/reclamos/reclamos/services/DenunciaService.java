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

    public void saveDenuncia(String descripcion, EstadoDenuncia estadoDenuncia, TipoDenuncia tipoDenuncia, String titulo, String causa, String lugar, Long sitioId, Long denunciadoId, Long denuncianteId, Long inspectorId, MultipartFile[] files) throws IOException {
        Denuncia denuncia = new Denuncia();
        denuncia.setDescripcion(descripcion);
        denuncia.setEstadoDenuncia(estadoDenuncia);
        denuncia.setTipoDenuncia(tipoDenuncia);
        denuncia.setTitulo(titulo);
        denuncia.setCausa(causa);
        denuncia.setLugar(lugar);

        if (sitioId != null) {
            Sitio sitio = sitioRepository.findById(sitioId).orElseThrow(() -> new RuntimeException("Sitio not found"));
            denuncia.setSitioDenunciado(sitio);
        }

        if (denunciadoId != null) {
            Vecino denunciado = vecinoRepository.findById(denunciadoId).orElseThrow(() -> new RuntimeException("Vecino not found"));
            denuncia.setDenunciado(denunciado);
        }

        if (denuncianteId != null) {
            Vecino denunciante = vecinoRepository.findById(denuncianteId).orElseThrow(() -> new RuntimeException("Vecino not found"));
            denuncia.setDenunciante(denunciante);
        }

        if (inspectorId != null) {
            Inspector inspector = inspectorRepository.findById(inspectorId).orElseThrow(() -> new RuntimeException("Inspector not found"));
            denuncia.setInspector(inspector);
        }

        // Manejo de múltiples archivos
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                byte[] fileContent = file.getBytes();
                // Puedes almacenar el archivo en la base de datos, en el sistema de archivos, etc.
                // Aquí simplemente imprimimos el nombre del archivo y su tamaño
                System.out.println("Archivo recibido: " + file.getOriginalFilename() + " tamaño: " + fileContent.length);
                // Denuncia puede tener un campo de colección para almacenar las pruebas
                // denuncia.addPrueba(fileContent); // Si se maneja como una colección de bytes
            }
        }

        denunciaRepository.save(denuncia);
    }

    public List<Denuncia> getDenunciasByDenunciante(Long denuncianteDocumento) {
        return denunciaRepository.findByDenuncianteDocumento(denuncianteDocumento);
    }

}