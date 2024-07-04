package com.reclamos.reclamos.controllers;
import com.reclamos.reclamos.enums.EstadoReclamo;
import com.reclamos.reclamos.enums.TipoReclamo;
import com.reclamos.reclamos.model.Reclamo;
import com.reclamos.reclamos.repositorios.InspectorRepository;
import com.reclamos.reclamos.repositorios.ReclamoRepository;
import com.reclamos.reclamos.repositorios.SitioRepository;
import com.reclamos.reclamos.repositorios.VecinoRepository;
import com.reclamos.reclamos.services.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/reclamos")
public class ReclamoController {
    @Autowired
    private ReclamoService reclamoService;


    @GetMapping
    public List<Reclamo> getAllReclamos() {
        return reclamoService.getAllReclamos();
    }

    @GetMapping("/{id}")
    public Reclamo getReclamoById(@PathVariable Long id) {
        return reclamoService.getReclamoById(id);
    }

    @PostMapping
    public Reclamo createReclamo(@RequestBody Reclamo reclamo) {
        return reclamoService.createReclamo(reclamo);
    }

    @PutMapping("/{id}")
    public Reclamo updateReclamo(@PathVariable Long id, @RequestBody Reclamo reclamo) {
        return reclamoService.updateReclamo(id, reclamo);
    }

    @DeleteMapping("/{id}")
    public void deleteReclamo(@PathVariable Long id) {
        reclamoService.deleteReclamo(id);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadReclamo(
            @RequestParam("descripcion") String descripcion,
            @RequestParam("tipoReclamo") TipoReclamo tipoReclamo,
            @RequestParam("desperfecto") String desperfecto,
            @RequestParam(value = "sitioId", required = false) Long sitioId,
            @RequestParam(value = "vecinoId", required = false) Long vecinoId,
            @RequestParam(value = "inspectorId", required = false) Long inspectorId,
            @RequestParam(value = "estadoReclamo", defaultValue = "ACTIVO") EstadoReclamo estadoReclamo,
            @RequestParam(value = "fotos", required = false) MultipartFile[] fotos) {

        try {
            reclamoService.saveReclamo(descripcion, tipoReclamo, desperfecto, sitioId, vecinoId, inspectorId, estadoReclamo, fotos);
            return ResponseEntity.status(HttpStatus.OK).body("Reclamo subido exitosamente");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar archivos");
        }
    }

    @GetMapping("/inspector/{legajo}")
    public List<Reclamo> getReclamosByInspector(@PathVariable Long legajo) {
        return reclamoService.getReclamosByInspector(legajo);
    }

    @GetMapping("/vecino/{documento}")
    public List<Reclamo> getReclamosByVecino(@PathVariable Long documento) {
        return reclamoService.getReclamosByVecino(documento);
    }

}
