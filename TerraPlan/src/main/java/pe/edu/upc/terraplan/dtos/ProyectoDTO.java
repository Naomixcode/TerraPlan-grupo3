package pe.edu.upc.terraplan.dtos;

import pe.edu.upc.terraplan.entities.Usuario;

import java.time.LocalDate;

public class ProyectoDTO {
    private int idProyecto;
    private String nombreProyecto;
    private String descripcionProyecto;
    private LocalDate fechaCreacionProyecto;
    private String estadoProyecto;
    private Usuario usuarioProyecto;  // Relación con Usuario



    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public LocalDate getFechaCreacionProyecto() {
        return fechaCreacionProyecto;
    }

    public void setFechaCreacionProyecto(LocalDate fechaCreacionProyecto) {
        this.fechaCreacionProyecto = fechaCreacionProyecto;
    }

    public String getEstadoProyecto() {
        return estadoProyecto;
    }

    public void setEstadoProyecto(String estadoProyecto) {
        this.estadoProyecto = estadoProyecto;
    }

    public Usuario getUsuarioProyecto() {
        return usuarioProyecto;
    }

    public void setUsuarioProyecto(Usuario usuarioProyecto) {
        this.usuarioProyecto = usuarioProyecto;
    }
}
