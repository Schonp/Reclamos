package com.reclamos.reclamos.controllers;
import com.reclamos.reclamos.model.Notificacion;
import com.reclamos.reclamos.services.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {
    @Autowired
    private NotificacionService notificacionService;

    @GetMapping
    public List<Notificacion> getAllNotificaciones() {
        return notificacionService.getAllNotificaciones();
    }

    @GetMapping("/{id}")
    public Notificacion getNotificacionById(@PathVariable Long id) {
        return notificacionService.getNotificacionById(id);
    }

    @PostMapping
    public Notificacion createNotificacion(@RequestBody Notificacion notificacion) {
        return notificacionService.createNotificacion(notificacion);
    }

    @PutMapping("/{id}")
    public Notificacion updateNotificacion(@PathVariable Long id, @RequestBody Notificacion notificacion) {
        return notificacionService.updateNotificacion(id, notificacion);
    }

    @DeleteMapping("/{id}")
    public void deleteNotificacion(@PathVariable Long id) {
        notificacionService.deleteNotificacion(id);
    }
}

