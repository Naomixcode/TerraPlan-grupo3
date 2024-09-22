package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.si62_grupo_01.dtos.PrototipoMaterialDTO;
import pe.edu.upc.si62_grupo_01.entities.PrototipoMaterial;
import pe.edu.upc.si62_grupo_01.servicesinterfaces.IPrototipoMaterialService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/prototipo_material")
public class PrototipoMaterialController {
    @Autowired
    private IPrototipoMaterialService prototipoMaterialService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public List<PrototipoMaterialDTO> listar() {
        return prototipoMaterialService.list().stream().map(x-> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PrototipoMaterialDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    private  void insertar(@RequestBody PrototipoMaterialDTO prototipoMaterialDTO) {
        ModelMapper m = new ModelMapper();
        PrototipoMaterial prototipoMaterial=m.map(prototipoMaterialDTO,PrototipoMaterial.class);
        prototipoMaterialService.insert(prototipoMaterial);
    }
    @PutMapping()
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    private  void modificar(@RequestBody PrototipoMaterialDTO prototipoMaterialDTO) {
        ModelMapper m = new ModelMapper();
        PrototipoMaterial prototipoMaterial=m.map(prototipoMaterialDTO,PrototipoMaterial.class);
        prototipoMaterialService.update(prototipoMaterial);
    }
    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public void elimina(@PathVariable ("id") Integer id){
        prototipoMaterialService.delete(id);
    }

}
