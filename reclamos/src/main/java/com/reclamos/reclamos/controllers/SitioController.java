package com.reclamos.reclamos.controllers;
import com.reclamos.reclamos.model.Sitio;
import com.reclamos.reclamos.services.SitioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sitios")
public class SitioController {
    @Autowired
    private SitioService sitioService;

    @GetMapping
    public List<Sitio> getAllSitios() {
        return sitioService.getAllSitios();
    }

    @GetMapping("/{id}")
    public Sitio getSitioById(@PathVariable Long id) {
        return sitioService.getSitioById(id);
    }

    @PostMapping
    public Sitio createSitio(@RequestBody Sitio sitio) {
        return sitioService.createSitio(sitio);
    }

    @PutMapping("/{id}")
    public Sitio updateSitio(@PathVariable Long id, @RequestBody Sitio sitio) {
        return sitioService.updateSitio(id, sitio);
    }

    @DeleteMapping("/{id}")
    public void deleteSitio(@PathVariable Long id) {
        sitioService.deleteSitio(id);
    }
}

