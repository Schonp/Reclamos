package com.reclamos.reclamos.controllers;
import com.reclamos.reclamos.model.Promocion;
import com.reclamos.reclamos.services.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
}

