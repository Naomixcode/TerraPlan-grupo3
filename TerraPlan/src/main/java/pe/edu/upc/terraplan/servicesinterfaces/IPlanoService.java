package pe.edu.upc.terraplan.servicesinterfaces;

import pe.edu.upc.si62_grupo_01.entities.Plano;

import java.util.List;

public interface IPlanoService {
    public List<Plano> list();
    public void insert(Plano plano);
    public void update(Plano plano);
    public void delete(int id);
}
