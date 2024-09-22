package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.si62_grupo_01.dtos.PermisoDTO;
import pe.edu.upc.si62_grupo_01.entities.Permiso;
import pe.edu.upc.si62_grupo_01.servicesinterfaces.IPermisoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/permiso")
public class PermisoController {
    @Autowired
    private IPermisoService permisoService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public List<PermisoDTO> listar() {
        return permisoService.list().stream().map(x-> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PermisoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    private  void insertar(@RequestBody PermisoDTO dto) {
        ModelMapper m = new ModelMapper();
        Permiso permiso=m.map(dto,Permiso.class);
        permisoService.insert(permiso);
    }
    @PutMapping()
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public void modificar(@RequestBody PermisoDTO permisoDTO) {
        ModelMapper m= new ModelMapper();
        Permiso permiso= m.map(permisoDTO, Permiso.class);
        permisoService.update(permiso);
    }
    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public void elimina(@PathVariable ("id") Integer id){
        permisoService.delete(id);
    }

}
