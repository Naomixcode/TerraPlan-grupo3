package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.si62_grupo_01.dtos.EvaluacionDTO;
import pe.edu.upc.si62_grupo_01.entities.Evaluacion;
import pe.edu.upc.si62_grupo_01.servicesinterfaces.IEvaluacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/evaluacion")
public class EvaluacionController {
    @Autowired
    private IEvaluacionService eS;


    @PostMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    private void insertar(@RequestBody EvaluacionDTO dto) {
        ModelMapper m= new ModelMapper();
        Evaluacion evaluacion= m.map(dto, Evaluacion.class);
        eS.insert(evaluacion);
    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public List<EvaluacionDTO> listar() {
        return eS.list().stream().map(x->
        {
            ModelMapper m= new ModelMapper();
            return m.map(x,EvaluacionDTO.class);
        }).collect(Collectors.toList());
    }
    @PutMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public void modificar(@RequestBody EvaluacionDTO evaluacionDTO){
        ModelMapper m= new ModelMapper();
        Evaluacion e= m.map(evaluacionDTO,Evaluacion.class);
        eS.update(e);
    }
    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")
    public void eliminar(@PathVariable ("id")Integer id){
        eS.delete(id);
    }
}
