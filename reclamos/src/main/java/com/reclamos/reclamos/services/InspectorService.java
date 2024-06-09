package com.reclamos.reclamos.services;
import com.reclamos.reclamos.model.Inspector;
import com.reclamos.reclamos.repositorios.InspectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InspectorService {
    @Autowired
    private InspectorRepository inspectorRepository;

    public List<Inspector> getAllInspectores() {
        return inspectorRepository.findAll();
    }

    public Inspector getInspectorById(int legajo) {
        return inspectorRepository.findById((long) legajo).orElse(null);
    }

    public Inspector createInspector(Inspector inspector) {
        return inspectorRepository.save(inspector);
    }

    public Inspector updateInspector(int legajo, Inspector inspector) {
        if (inspectorRepository.existsById((long) legajo)) {
            inspector.setLegajo((long) legajo);
            return inspectorRepository.save(inspector);
        }
        return null;
    }

    public void deleteInspector(int legajo) {
        inspectorRepository.deleteById((long) legajo);
    }
}
