package com.reclamos.reclamos.controllers;
import com.reclamos.reclamos.model.Movimiento;
import com.reclamos.reclamos.services.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public List<Movimiento> getAllMovimientos() {
        return movimientoService.getAllMovimientos();
    }

    @GetMapping("/{id}")
    public Movimiento getMovimientoById(@PathVariable Long id) {
        return movimientoService.getMovimientoById(id);
    }

    @PostMapping
    public Movimiento createMovimiento(@RequestBody Movimiento movimiento) {
        return movimientoService.createMovimiento(movimiento);
    }

    @PutMapping("/{id}")
    public Movimiento updateMovimiento(@PathVariable Long id, @RequestBody Movimiento movimiento) {
        return movimientoService.updateMovimiento(id, movimiento);
    }

    @DeleteMapping("/{id}")
    public void deleteMovimiento(@PathVariable Long id) {
        movimientoService.deleteMovimiento(id);
    }
}

