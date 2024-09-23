package pe.edu.upc.terraplan.servicesinterfaces;

import pe.edu.upc.terraplan.dtos.ComentarioCountByProyectoDTO;
import pe.edu.upc.terraplan.dtos.ComentarioCountDTO;
import pe.edu.upc.terraplan.entities.Comentario;

import java.util.List;

public interface IComentarioService {
    public List<Comentario> list();

    public void insert(Comentario comentario);

    public void update(Comentario comentario);

    public void delete(int id);

    public List<ComentarioCountDTO> contarComentariosPorUsuario(Long idUsuario);

    List<ComentarioCountByProyectoDTO> contarComentariosPorProyecto(int idProyecto);
}