package com.reclamos.reclamos.controllers;
import com.reclamos.reclamos.enums.EstadoPromocion;
import com.reclamos.reclamos.enums.TipoPromocion;
import com.reclamos.reclamos.model.Promocion;
import com.reclamos.reclamos.services.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/promociones")
public class PromocionController {
    @Autowired
    private PromocionService promocionService;

    @GetMapping
    public List<Promocion> getAllPromociones() {
        return promocionService.getAllPromociones();
    }

    @GetMapping("/{id}")
    public Promocion getPromocionById(@PathVariable Long id) {
        return promocionService.getPromocionById(id);
    }

    @PostMapping
    public Promocion createPromocion(@RequestBody Promocion promocion) {
        return promocionService.createPromocion(promocion);
    }

    @PutMapping("/{id}")
    public Promocion updatePromocion(@PathVariable Long id, @RequestBody Promocion promocion) {
        return promocionService.updatePromocion(id, promocion);
    }

    @DeleteMapping("/{id}")
    public void deletePromocion(@PathVariable Long id) {
        promocionService.deletePromocion(id);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadPromocion(
            @RequestParam("descripcion") String descripcion,
            @RequestParam("tipoPromocion") TipoPromocion tipoPromocion,
            @RequestParam("titulo") String titulo,
            @RequestParam("horarios") String horarios,
            @RequestParam("direccion") String direccion,
            @RequestParam("contacto") String contacto,
            @RequestParam("estadoPromocion") EstadoPromocion estadoPromocion,
            @RequestParam(value = "sitioId", required = false) Long sitioId,
            @RequestParam(value = "rubroId", required = false) Long rubroId,
            @RequestParam(value = "vecinoId", required = false) Long vecinoId,
            @RequestParam(value = "fotos", required = false) MultipartFile[] fotos) {

        try {
            promocionService.savePromocion(descripcion, tipoPromocion, titulo, horarios, direccion, contacto, sitioId, rubroId, vecinoId, estadoPromocion, fotos);
            return ResponseEntity.status(HttpStatus.OK).body("Promoción subida exitosamente");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar archivos");
        }
    }
}

