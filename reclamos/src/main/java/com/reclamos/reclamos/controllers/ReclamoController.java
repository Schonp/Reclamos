package com.reclamos.reclamos.controllers;
import com.reclamos.reclamos.model.Reclamo;
import com.reclamos.reclamos.services.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
}
