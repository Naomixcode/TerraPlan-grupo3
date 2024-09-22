package pe.edu.upc.terraplan.servicesinterfaces;

import pe.edu.upc.si62_grupo_01.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> list();
    public void insert(Usuario usuario);
    public void delete(Long id);  // Cambiado de int a Long
    public void update(Usuario usuario);
}
