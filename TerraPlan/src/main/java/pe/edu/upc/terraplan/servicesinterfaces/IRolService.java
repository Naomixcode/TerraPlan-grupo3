package pe.edu.upc.terraplan.servicesinterfaces;

import pe.edu.upc.si62_grupo_01.entities.Rol;

import java.util.List;
public interface IRolService {
    public List<Rol>list();
    public void insert(Rol rol);
    public void delete(int id);
    public void update(Rol rol);
}
