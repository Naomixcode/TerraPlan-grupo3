package pe.edu.upc.terraplan.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.terraplan.entities.Permiso;
import pe.edu.upc.terraplan.repositories.IPermisoRepository;
import pe.edu.upc.terraplan.servicesinterfaces.IPermisoService;

import java.util.List;

@Service
public class PermisoServiceImplement implements IPermisoService {
    @Autowired
    private IPermisoRepository permisoRepository;

    @Override
    public List<Permiso> list(){return permisoRepository.findAll();}

    @Override
    public void insert(Permiso permiso) {
        permisoRepository.save(permiso);
    }

    @Override
    public void delete(int id) {
        permisoRepository.deleteById(id);
    }

    @Override
    public void update(Permiso permiso) {
        permisoRepository.save(permiso);
    }

}