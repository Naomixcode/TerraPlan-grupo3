package pe.edu.upc.terraplan.servicesinterfaces;

import pe.edu.upc.si62_grupo_01.entities.Material;

import java.util.List;

public interface IMaterialService {
    public List<Material> list();
    public void insert(Material material);
    public void delete(int id);
    public void update(Material material);
}
