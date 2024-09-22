package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.si62_grupo_01.dtos.UsuarioDTO;
import pe.edu.upc.si62_grupo_01.entities.Usuario;
import pe.edu.upc.si62_grupo_01.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Método POST para registrar un nuevo usuario
    @PostMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")
    public void insertar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario usuario = m.map(dto, Usuario.class);
        String encodedPassword = passwordEncoder.encode(usuario.getContrasenia());
        usuario.setContrasenia(encodedPassword);
        uS.insert(usuario);
    }

    // Método GET para listar todos los usuarios
    @GetMapping
    @PreAuthorize("hasAnyAuthority( 'Admin')")
    public List<UsuarioDTO> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    // Método PUT para modificar un usuario existente
    @PutMapping
    @PreAuthorize("hasAnyAuthority('Usuario', 'Admin')")
    public void modificar(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper m = new ModelMapper();
        Usuario usuario = m.map(usuarioDTO, Usuario.class);

        // Codificar nuevamente la contraseña antes de actualizar
        String encodedPassword = passwordEncoder.encode(usuario.getContrasenia());
        usuario.setContrasenia(encodedPassword);

        uS.update(usuario);
    }

    // Método DELETE para eliminar un usuario por ID
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('Admin')")
    public void eliminar(@PathVariable("id") Long id) {
        uS.delete(id);
    }


}
