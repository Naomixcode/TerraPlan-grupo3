package pe.edu.upc.terraplan.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionServiceImplement implements INotificacionService {
    @Autowired
    private INotificacionRepository repositoryNotificacion;
    @Override
    public List<Notificacion> list() {
        return repositoryNotificacion.findAll();
    }

    @Override
    public void insert(Notificacion notificacion) {
        repositoryNotificacion.save(notificacion);
    }

    @Override
    public void delete(int id) {
        repositoryNotificacion.deleteById(id);
    }

    @Override
    public void update(Notificacion notificacion) {
        repositoryNotificacion.save(notificacion);
    }
}
