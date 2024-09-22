package pe.edu.upc.terraplan.servicesinterfaces;

import pe.edu.upc.si62_grupo_01.entities.Notificacion;

import java.util.List;

public interface INotificacionService {
    public List<Notificacion> list();
    public void insert(Notificacion notificacion);
    public void delete(int id);
    public void update(Notificacion notificacion);
}
