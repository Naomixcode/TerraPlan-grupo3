package pe.edu.upc.terraplan.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.terraplan.entities.Usuario;
import pe.edu.upc.terraplan.repositories.IUsuarioRepository;
import pe.edu.upc.terraplan.servicesinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {

    @Autowired
    private IUsuarioRepository uR;

    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }



    @Override
    public void insert(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public void delete(Long id) { // Cambiado de int a Long
        uR.deleteById(id);
    }

    @Override
    public void update(Usuario usuario) {
        uR.save(usuario);
    }




}
