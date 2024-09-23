package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.terraplan.dtos.ComentarioCountDTO;
import pe.edu.upc.terraplan.dtos.ComentarioDTO;
import pe.edu.upc.terraplan.entities.Comentario;
import pe.edu.upc.terraplan.servicesinterfaces.IComentarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    private IComentarioService comentarioService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")
    private void insertar(@RequestBody ComentarioDTO comentarioDTO) {
        ModelMapper m = new ModelMapper();
        Comentario comentario = m.map(comentarioDTO, Comentario.class);
        comentarioService.insert(comentario);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public List<ComentarioDTO> listar() {
        return comentarioService.list().stream().map(x ->
        {
            ModelMapper m = new ModelMapper();
            return m.map(x, ComentarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    private void modificar(@RequestBody ComentarioDTO comentarioDTO) {
        ModelMapper m = new ModelMapper();
        Comentario comentario = m.map(comentarioDTO, Comentario.class);

    }

    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public void eliminar(@PathVariable("id") Integer id) {
        comentarioService.delete(id);
    }

    @GetMapping("/contar-por-usuario/{idUsuario}")
    @PreAuthorize("hasAuthority('Admin')")
    public List<ComentarioCountDTO> contarComentariosPorUsuario(@PathVariable("idUsuario") Long idUsuario) {
        return comentarioService.contarComentariosPorUsuario(idUsuario);
    }

}
