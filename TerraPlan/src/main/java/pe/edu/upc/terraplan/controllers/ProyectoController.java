package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.si62_grupo_01.dtos.*;
import pe.edu.upc.si62_grupo_01.entities.Proyecto;
import pe.edu.upc.si62_grupo_01.servicesinterfaces.IProyectoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {
    @Autowired
    private IProyectoService proyectoService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public List<ProyectoDTO> listar() {
        return proyectoService.list().stream().map(x-> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ProyectoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    private  void insertar(@RequestBody ProyectoDTO dto) {
        ModelMapper m = new ModelMapper();
        Proyecto proyecto=m.map(dto, Proyecto.class);
        proyectoService.insert(proyecto);
    }
    @PutMapping()
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public void modificar(@RequestBody ProyectoDTO proyectoDTO) {
        ModelMapper m= new ModelMapper();
        Proyecto proyecto= m.map(proyectoDTO, Proyecto.class);
        proyectoService.update(proyecto);
    }
    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public void elimina(@PathVariable ("id") Integer id){
        proyectoService.delete(id);
    }

    @GetMapping("/contar-por-usuario/{idUsuario}")//sifunciona
    @PreAuthorize("hasAnyAuthority( 'Admin')")
    public List<ProyectoCountDTO> contarProyectosPorUsuario(@PathVariable("idUsuario") Long idUsuario) {
        return proyectoService.contarProyectosPorUsuario(idUsuario);
    }
    @GetMapping("/contar_proyectos_estado")  //si funciona
    @PreAuthorize("hasAnyAuthority( 'Admin')")
    public List<ProyectosCountByEstado>contarEstadosPorProyecto()
    {
        List<String[]>lista= proyectoService.contarEstadosPorProyecto();
        List<ProyectosCountByEstado>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            ProyectosCountByEstado dto=new ProyectosCountByEstado();
            dto.setEstado(columna[0]);
            dto.setCantidad(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    @GetMapping("/listar_proyectos_estado/{estadoProyecto}")//si funciona
    @PreAuthorize("hasAnyAuthority( 'Admin')")
    public List<ProyectosListByEstado>listarProyectosEstado(@PathVariable String estadoProyecto)
    {
        List<String[]>lista=proyectoService.listarProyectosPorEstado(estadoProyecto);
        List<ProyectosListByEstado>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            ProyectosListByEstado dto=new ProyectosListByEstado();
            dto.setIdUsuario(Integer.parseInt(columna[0]));
            dto.setNombre(columna[1]);
            dto.setProyecto(columna[2]);
            dto.setEstado(columna[3]);
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    @GetMapping("/permisos_proyectos") // si funciona
    @PreAuthorize("hasAnyAuthority( 'Admin')")
    public  List<PermisosCountByProyectosDTO>contarPermisosPorProyectos(){
        List<String[]>lista=proyectoService.contarPermisosDeProyectos();
        List<PermisosCountByProyectosDTO>listaDto= new ArrayList<>();
        for(String[]columna:lista){
            PermisosCountByProyectosDTO dto=new PermisosCountByProyectosDTO();
            dto.setIdUsuario(Long.parseLong(columna[0]));
            dto.setNombreusuario(columna[1]);
            dto.setProyecto(columna[2]);
            dto.setNumPermisos(Integer.parseInt(columna[3]));
            listaDto.add(dto);
        }
        return listaDto;
    }
    @GetMapping("/permisos_proyectos_usuario/{idUsuario}") // funciona
    @PreAuthorize("hasAnyAuthority( 'Admin')")
    public  List<PermisosCountByProyectosDTO>contarPermisosPorProyectosUsuario(@PathVariable Long idUsuario){
        List<String[]>lista=proyectoService.contarPermisosDeProyectosPorUsuario(idUsuario);
        List<PermisosCountByProyectosDTO>listaDto= new ArrayList<>();
        for(String[]columna:lista){
            PermisosCountByProyectosDTO dto=new PermisosCountByProyectosDTO();
            dto.setProyecto(columna[0]);
            dto.setNumPermisos(Integer.parseInt(columna[1]));
            listaDto.add(dto);
        }
        return listaDto;
    }
    @GetMapping("/terrenos_proyectos")  //si funciona
    @PreAuthorize("hasAnyAuthority( 'Admin')")
    public  List<TerrenoCountByProyectoDTO>contarTerrenosPorProyectos()
    {
        List<String[]>lista=proyectoService.contarTerrenosDeProyectos();
        List<TerrenoCountByProyectoDTO>listaDto= new ArrayList<>();
        for(String[]columna:lista){
            TerrenoCountByProyectoDTO dto= new TerrenoCountByProyectoDTO();
            dto.setProyectoId(Integer.parseInt(columna[0]));
            dto.setProyectoNombre(columna[1]);
            dto.setNumTerrenos(Integer.parseInt(columna[2]));
            listaDto.add(dto);
        }
        return listaDto;
    }
    @GetMapping("/terrenos_por_proyecto/{idProyecto}") //funciona
    @PreAuthorize("hasAnyAuthority( 'Admin')")
    public List<TerrenoDTO> contarTerrenosPorProyecto(@PathVariable("idProyecto")Integer idProyecto){
        List<String[]>lista=proyectoService.contarTerrenosPorProyecto(idProyecto);
        List<TerrenoDTO>listaDto= new ArrayList<>();
        for (String[] columna:lista){
            TerrenoDTO dto= new TerrenoDTO();
            dto.setIdTerreno(Integer.parseInt(columna[0]));
            dto.setUbicacionTerreno(columna[1]);
            dto.setTamanioTerreno(Float.parseFloat(columna[2]));
            dto.setDescripcionTerreno(columna[3]);
            listaDto.add(dto);

        }
        return listaDto;
    }

}