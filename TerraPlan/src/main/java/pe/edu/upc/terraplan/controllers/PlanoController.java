package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.terraplan.dtos.PlanoDTO;
import pe.edu.upc.terraplan.entities.Plano;
import pe.edu.upc.terraplan.servicesinterfaces.IPlanoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plano")
public class PlanoController {
    @Autowired
    private IPlanoService planoService;
    @GetMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public List<PlanoDTO> listar() {
        return planoService.list().stream().map(x-> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PlanoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    private  void insertar(@RequestBody PlanoDTO planoDTO) {
        ModelMapper m = new ModelMapper();
        Plano plano=m.map(planoDTO,Plano.class);
        planoService.insert(plano);
    }
    @PutMapping()
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public void modificar(@RequestBody PlanoDTO planoDTO) {
        ModelMapper m= new ModelMapper();
        Plano plano= m.map(planoDTO, Plano.class);
        planoService.update(plano);
    }
    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")

    public void elimina(@PathVariable ("id") Integer id){
        planoService.delete(id);
    }

}
