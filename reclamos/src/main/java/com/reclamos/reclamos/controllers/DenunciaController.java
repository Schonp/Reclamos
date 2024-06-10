package com.reclamos.reclamos.controllers;
import com.reclamos.reclamos.model.Denuncia;
import com.reclamos.reclamos.services.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
}

