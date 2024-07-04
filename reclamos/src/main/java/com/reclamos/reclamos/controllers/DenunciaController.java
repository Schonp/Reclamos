package com.reclamos.reclamos.controllers;

import com.reclamos.reclamos.enums.EstadoDenuncia;
import com.reclamos.reclamos.enums.TipoDenuncia;
import com.reclamos.reclamos.model.Denuncia;
import com.reclamos.reclamos.services.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/denuncias")
public class DenunciaController {

    @Autowired
    private DenunciaService denunciaService;

    @GetMapping
    public List<Denuncia> getAllDenuncias() {
        return denunciaService.getAllDenuncias();
    }

    @GetMapping("/{id}")
    public Denuncia getDenunciaById(@PathVariable Long id) {
        return denunciaService.getDenunciaById(id);
    }

    @PostMapping
    public Denuncia createDenuncia(@RequestBody Denuncia denuncia) {
        return denunciaService.createDenuncia(denuncia);
    }

    @PutMapping("/{id}")
    public Denuncia updateDenuncia(@PathVariable Long id, @RequestBody Denuncia denuncia) {
        return denunciaService.updateDenuncia(id, denuncia);
    }

    @DeleteMapping("/{id}")
    public void deleteDenuncia(@PathVariable Long id) {
        denunciaService.deleteDenuncia(id);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDenuncia(
            @RequestParam("descripcion") String descripcion,
            @RequestParam("estadoDenuncia") EstadoDenuncia estadoDenuncia,
            @RequestParam("tipoDenuncia") TipoDenuncia tipoDenuncia,
            @RequestParam("titulo") String titulo,
            @RequestParam("causa") String causa,
            @RequestParam("lugar") String lugar,
            @RequestParam(value = "sitioId", required = false) Long sitioId,
            @RequestParam(value = "denunciadoId", required = false) Long denunciadoId,
            @RequestParam(value = "denuncianteId", required = false) Long denuncianteId,
            @RequestParam(value = "inspectorId", required = false) Long inspectorId,
            @RequestParam(value = "pruebas",required = false) MultipartFile[] pruebas) {

        try {
            denunciaService.saveDenuncia(descripcion, estadoDenuncia, tipoDenuncia, titulo, causa, lugar, sitioId, denunciadoId, denuncianteId, inspectorId, pruebas);
            return ResponseEntity.status(HttpStatus.OK).body("Denuncia subida exitosamente");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar archivos");
        }
    }
}
