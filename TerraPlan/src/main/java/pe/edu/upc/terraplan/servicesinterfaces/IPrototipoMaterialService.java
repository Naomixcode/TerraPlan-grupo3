package pe.edu.upc.terraplan.servicesinterfaces;

import pe.edu.upc.si62_grupo_01.entities.PrototipoMaterial;

import java.util.List;

public interface IPrototipoMaterialService {
    public List<PrototipoMaterial> list() ;
    public void insert(PrototipoMaterial prototipoMaterial) ;
    public void update(PrototipoMaterial prototipoMaterial) ;
    public void delete(int id) ;


}
