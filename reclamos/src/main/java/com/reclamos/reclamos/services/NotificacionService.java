package com.reclamos.reclamos.services;
import com.reclamos.reclamos.model.Notificacion;
import com.reclamos.reclamos.repositorios.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificacionService {
    @Autowired
    private NotificacionRepository notificacionRepository;

    public List<Notificacion> getAllNotificaciones() {
        return notificacionRepository.findAll();
    }

    public Notificacion getNotificacionById(Long id) {
        return notificacionRepository.findById(id).orElse(null);
    }

    public Notificacion createNotificacion(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public Notificacion updateNotificacion(Long id, Notificacion notificacion) {
        if (notificacionRepository.existsById(id)) {
            notificacion.setIdNotificacion(id);
            return notificacionRepository.save(notificacion);
        }
        return null;
    }

    public void deleteNotificacion(Long id) {
        notificacionRepository.deleteById(id);
    }

    public List<Notificacion> getNotificacionesByVecino(Long documento) {
        return notificacionRepository.findByVecinoDocumento(documento);
    }

    public List<Notificacion> getNotificacionesByInspector(Long legajo) {
        return notificacionRepository.findByInspectorLegajo(legajo);
    }
}

