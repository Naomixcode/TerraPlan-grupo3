package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.si62_grupo_01.dtos.TerrenoCountByDepartamentoDTO;
import pe.edu.upc.si62_grupo_01.dtos.TerrenoDTO;
import pe.edu.upc.si62_grupo_01.entities.Terreno;
import pe.edu.upc.si62_grupo_01.servicesinterfaces.ITerrenoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("terreno")
public class TerrenoController {
    @Autowired
    private ITerrenoService terrenoService;
    @GetMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")
    public List<TerrenoDTO>listarTerrenos(){
        return terrenoService.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x, TerrenoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")
    private void insertar(@RequestBody TerrenoDTO terrenoDTO){
        ModelMapper m= new ModelMapper();
        Terreno t=m.map(terrenoDTO, Terreno.class);
        terrenoService.insert(t);
    }
    @PutMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")
    public void modificar(@RequestBody TerrenoDTO terrenoDTO){
        ModelMapper m= new ModelMapper();
        Terreno t= m.map(terrenoDTO,Terreno.class);
        terrenoService.update(t);
    }
    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")
    public void eliminar(@PathVariable ("id")Integer id){
        terrenoService.delete(id);
    }

    @GetMapping("/terrenos_departamento") //funciona
    @PreAuthorize("hasAnyAuthority( 'Admin')")
    public List<TerrenoCountByDepartamentoDTO>cantidadTerrenosDepartamento(){
        List<String[]>lista=terrenoService.CantidadTerrenosUbicaicon();
        List<TerrenoCountByDepartamentoDTO>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            TerrenoCountByDepartamentoDTO dto=new TerrenoCountByDepartamentoDTO();
            dto.setUbicacionTerreno(columna[0]);
            dto.setCantidad(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
