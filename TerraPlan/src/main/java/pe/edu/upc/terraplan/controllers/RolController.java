package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.si62_grupo_01.dtos.RolDTO;
import pe.edu.upc.si62_grupo_01.entities.Rol;
import pe.edu.upc.si62_grupo_01.servicesinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private IRolService rolService;

    // Método GET para listar todos los roles
    @GetMapping
    @PreAuthorize("hasAnyAuthority( 'Admin')")
    public List<RolDTO> listar() {
        return rolService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

    // Método POST para registrar un nuevo rol
    @PostMapping
    @PreAuthorize("hasAnyAuthority( 'Admin')")
    public void registrar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(dto, Rol.class);
        rolService.insert(rol);
    }

    // Método PUT para modificar un rol existente
    @PutMapping
    @PreAuthorize("hasAnyAuthority('Admin')")
    public void modificar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(dto, Rol.class);
        rolService.update(rol);
    }

    // Método DELETE para eliminar un rol por ID
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority( 'Admin')")
    public void eliminar(@PathVariable("id") Integer id) {
        rolService.delete(id);
    }
}
