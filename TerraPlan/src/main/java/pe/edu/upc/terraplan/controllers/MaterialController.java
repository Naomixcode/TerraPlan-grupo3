package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.si62_grupo_01.dtos.MaterialDTO;
import pe.edu.upc.si62_grupo_01.entities.Material;
import pe.edu.upc.si62_grupo_01.servicesinterfaces.IMaterialService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    private IMaterialService materialService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public List<MaterialDTO> listar() {
        return materialService.list().stream().map(x-> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MaterialDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    private  void insertar(@RequestBody MaterialDTO dto) {
        ModelMapper m = new ModelMapper();
        Material material=m.map(dto,Material.class);
        materialService.insert(material);
    }
    @PutMapping()
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public void modificar(@RequestBody MaterialDTO materialDTO) {
        ModelMapper m= new ModelMapper();
        Material d= m.map(materialDTO, Material.class);
        materialService.update(d);
    }
    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public void elimina(@PathVariable ("id") Integer id){
        materialService.delete(id);
    }
}
