package com.reclamos.reclamos.services;
import com.reclamos.reclamos.enums.EstadoPromocion;
import com.reclamos.reclamos.enums.TipoPromocion;
import com.reclamos.reclamos.model.Promocion;
import com.reclamos.reclamos.model.Rubro;
import com.reclamos.reclamos.model.Sitio;
import com.reclamos.reclamos.model.Vecino;
import com.reclamos.reclamos.repositorios.PromocionRepository;
import com.reclamos.reclamos.repositorios.RubroRepository;
import com.reclamos.reclamos.repositorios.SitioRepository;
import com.reclamos.reclamos.repositorios.VecinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PromocionService {
    @Autowired
    private PromocionRepository promocionRepository;

    @Autowired
    private SitioRepository sitioRepository;

    @Autowired
    private RubroRepository rubroRepository;

    @Autowired
    private VecinoRepository vecinoRepository;

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

    public void savePromocion(String descripcion, TipoPromocion tipoPromocion, String titulo, String horarios, String direccion, String contacto, Long sitioId, Long rubroId, Long vecinoId, EstadoPromocion estadoPromocion, MultipartFile[] fotos) throws IOException, IOException {
        Promocion promocion = new Promocion();
        promocion.setDescripcion(descripcion);
        promocion.setTipoPromocion(tipoPromocion);
        promocion.setTitulo(titulo);
        promocion.setHorarios(horarios);
        promocion.setDireccion(direccion);
        promocion.setContacto(contacto);
        promocion.setEstadoPromocion(estadoPromocion);

        if (sitioId != null) {
            Sitio sitio = sitioRepository.findById(sitioId).orElseThrow(() -> new RuntimeException("Sitio not found"));
            promocion.setSitio(sitio);
        }

        if (rubroId != null) {
            Rubro rubro = rubroRepository.findById(rubroId).orElseThrow(() -> new RuntimeException("Rubro not found"));
            promocion.setRubro(rubro);
        }

        if (vecinoId != null) {
            Vecino vecino = vecinoRepository.findById(vecinoId).orElseThrow(() -> new RuntimeException("Vecino not found"));
            promocion.setVecino(vecino);
        }

        // Manejo de múltiples archivos
        if (fotos != null && fotos.length > 0) {
            for (MultipartFile file : fotos) {
                byte[] fileContent = file.getBytes();
                // Puedes almacenar el archivo en la base de datos, en el sistema de archivos, etc.
                // Aquí simplemente imprimimos el nombre del archivo y su tamaño
                System.out.println("Archivo recibido: " + file.getOriginalFilename() + " tamaño: " + fileContent.length);
                // Promocion puede tener un campo de colección para almacenar las fotos
                // promocion.addFoto(fileContent); // Si se maneja como una colección de bytes
            }
        }

        promocionRepository.save(promocion);
    }
}
