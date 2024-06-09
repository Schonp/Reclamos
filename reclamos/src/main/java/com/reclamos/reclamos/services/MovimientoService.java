package com.reclamos.reclamos.services;
import com.reclamos.reclamos.model.Movimiento;
import com.reclamos.reclamos.repositorios.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;

    public List<Movimiento> getAllMovimientos() {
        return movimientoRepository.findAll();
    }

    public Movimiento getMovimientoById(Long id) {
        return movimientoRepository.findById(id).orElse(null);
    }

    public Movimiento createMovimiento(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    public Movimiento updateMovimiento(Long id, Movimiento movimiento) {
        if (movimientoRepository.existsById(id)) {
            movimiento.setIdMovimiento(id);
            return movimientoRepository.save(movimiento);
        }
        return null;
    }

    public void deleteMovimiento(Long id) {
        movimientoRepository.deleteById(id);
    }
}

