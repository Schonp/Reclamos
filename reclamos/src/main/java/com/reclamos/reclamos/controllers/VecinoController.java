package com.reclamos.reclamos.controllers;
import com.reclamos.reclamos.model.Vecino;
import com.reclamos.reclamos.services.VecinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vecinos")
public class VecinoController {
    @Autowired
    private VecinoService vecinoService;

    @GetMapping
    public List<Vecino> getAllVecinos() {
        return vecinoService.getAllVecinos();
    }

    @GetMapping("/{documento}")
    public Vecino getVecinoById(@PathVariable int documento) {
        return vecinoService.getVecinoById(documento);
    }

    @PostMapping
    public Vecino createVecino(@RequestBody Vecino vecino) {
        return vecinoService.createVecino(vecino);
    }

    @PutMapping("/{documento}")
    public Vecino updateVecino(@PathVariable int documento, @RequestBody Vecino vecino) {
        return vecinoService.updateVecino(documento, vecino);
    }

    @DeleteMapping("/{documento}")
    public void deleteVecino(@PathVariable int documento) {
        vecinoService.deleteVecino(documento);
    }
}

