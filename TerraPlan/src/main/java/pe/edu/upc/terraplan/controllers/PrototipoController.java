package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.terraplan.dtos.MaterialByPrototipo;
import pe.edu.upc.terraplan.dtos.PrototipoDTO;
import pe.edu.upc.terraplan.dtos.PrototiposCountByProyecto;
import pe.edu.upc.terraplan.entities.Prototipo;
import pe.edu.upc.terraplan.servicesinterfaces.IPrototipoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/prototipo")
public class PrototipoController {
    @Autowired
    private IPrototipoService prototipoService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public List<PrototipoDTO> listar() {
        return prototipoService.list().stream().map(x-> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PrototipoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    private  void insertar(@RequestBody PrototipoDTO prototipoDTO) {
        ModelMapper m = new ModelMapper();
        Prototipo prototipo=m.map(prototipoDTO,Prototipo.class);
        prototipoService.insert(prototipo);
    }
    @PutMapping()
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public void modificar(@RequestBody PrototipoDTO prototipoDTO) {
        ModelMapper m= new ModelMapper();
        Prototipo prototipo=m.map(prototipoDTO,Prototipo.class);
        prototipoService.update(prototipo);
    }
    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public void elimina(@PathVariable ("id") Integer id){
        prototipoService.delete(id);
    }
    @GetMapping("/materiales_prototipo_id/{idPrototipo}")
    @PreAuthorize("hasAnyAuthority('Admin')")

    public List<MaterialByPrototipo> listarMaterialesPrototipo(@PathVariable("idPrototipo") Integer idPrototipo) {
        List<String[]> lista = prototipoService.listaMaterialesId(idPrototipo);
        List<MaterialByPrototipo> listaMateriales = new ArrayList<>();
        for (String[] columna : lista) {
            MaterialByPrototipo dto = new MaterialByPrototipo();
            dto.setNombre(columna[0]);
            dto.setValor(Float.parseFloat(columna[1]));
            dto.setPrototipo(Integer.parseInt(columna[2]));
            listaMateriales.add(dto);
        }
        return listaMateriales;
    }
    @GetMapping("/prototipos_proyecto/{idProyecto}")
    public List<PrototiposCountByProyecto>listarPrototiposProyecto(@PathVariable("idProyecto") Integer idProyecto) {
        List<String[]>lista = prototipoService.costoPrototipo(idProyecto);
        List<PrototiposCountByProyecto>listaPrototipos= new ArrayList<>();
        for (String[] columna : lista) {
            PrototiposCountByProyecto dto = new PrototiposCountByProyecto();
            dto.setProyecto(columna[0]);
            dto.setIdTerreno(Integer.parseInt(columna[1]));
            dto.setUbicacion(columna[2]);
            dto.setIdPlano(Integer.parseInt(columna[3]));
            dto.setIdPrototipo(Integer.parseInt(columna[4]));
            dto.setCostoTotal(Float.parseFloat(columna[5]));
            listaPrototipos.add(dto);
        }
        return listaPrototipos;
    }
}