package com.reclamos.reclamos.services;
import com.reclamos.reclamos.enums.EstadoReclamo;
import com.reclamos.reclamos.enums.TipoReclamo;
import com.reclamos.reclamos.model.Inspector;
import com.reclamos.reclamos.model.Reclamo;
import com.reclamos.reclamos.model.Sitio;
import com.reclamos.reclamos.model.Vecino;
import com.reclamos.reclamos.repositorios.InspectorRepository;
import com.reclamos.reclamos.repositorios.ReclamoRepository;
import com.reclamos.reclamos.repositorios.SitioRepository;
import com.reclamos.reclamos.repositorios.VecinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReclamoService {
    @Autowired
    private ReclamoRepository reclamoRepository;

    @Autowired
    private SitioRepository sitioRepository;

    @Autowired
    private VecinoRepository vecinoRepository;

    @Autowired
    private InspectorRepository inspectorRepository;

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

    public void saveReclamo(String descripcion, TipoReclamo tipoReclamo, String desperfecto, Long sitioId, Long vecinoId, Long inspectorId, EstadoReclamo estadoReclamo, MultipartFile[] fotos) throws IOException {
        Reclamo reclamo = new Reclamo();
        reclamo.setDescripcion(descripcion);
        reclamo.setTipoReclamo(tipoReclamo);
        reclamo.setDesperfecto(desperfecto);
        reclamo.setEstadoReclamo(estadoReclamo);

        if (sitioId != null) {
            Sitio sitio = sitioRepository.findById(sitioId).orElseThrow(() -> new RuntimeException("Sitio not found"));
            reclamo.setSitio(sitio);
        }

        if (vecinoId != null) {
            Vecino vecino = vecinoRepository.findById(vecinoId).orElseThrow(() -> new RuntimeException("Vecino not found"));
            reclamo.setVecino(vecino);
        }

        if (inspectorId != null) {
            Inspector inspector = inspectorRepository.findById(inspectorId).orElseThrow(() -> new RuntimeException("Inspector not found"));
            reclamo.setInspector(inspector);
        }

        // Manejo de múltiples archivos
        if (fotos != null && fotos.length > 0) {
            for (MultipartFile file : fotos) {
                byte[] fileContent = file.getBytes();
                // Puedes almacenar el archivo en la base de datos, en el sistema de archivos, etc.
                // Aquí simplemente imprimimos el nombre del archivo y su tamaño
                System.out.println("Archivo recibido: " + file.getOriginalFilename() + " tamaño: " + fileContent.length);
                // Reclamo puede tener un campo de colección para almacenar las fotos
                // reclamo.addFoto(fileContent); // Si se maneja como una colección de bytes
            }
        }

        reclamoRepository.save(reclamo);
    }
    public List<Reclamo> getReclamosByInspector(Long inspectorLegajo) {
        return reclamoRepository.findByInspectorLegajo(inspectorLegajo);
    }

    public List<Reclamo> getReclamosByVecino(Long vecinoDocumento) {
        return reclamoRepository.findByVecinoDocumento(vecinoDocumento);
    }

}

