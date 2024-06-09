package com.reclamos.reclamos.controllers;
import com.reclamos.reclamos.model.Inspector;
import com.reclamos.reclamos.services.InspectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inspectores")
public class InspectorController {
    @Autowired
    private InspectorService inspectorService;

    @GetMapping
    public List<Inspector> getAllInspectores() {
        return inspectorService.getAllInspectores();
    }

    @GetMapping("/{legajo}")
    public Inspector getInspectorById(@PathVariable int legajo) {
        return inspectorService.getInspectorById(legajo);
    }

    @PostMapping
    public Inspector createInspector(@RequestBody Inspector inspector) {
        return inspectorService.createInspector(inspector);
    }

    @PutMapping("/{legajo}")
    public Inspector updateInspector(@PathVariable int legajo, @RequestBody Inspector inspector) {
        return inspectorService.updateInspector(legajo, inspector);
    }

    @DeleteMapping("/{legajo}")
    public void deleteInspector(@PathVariable int legajo) {
        inspectorService.deleteInspector(legajo);
    }
}

