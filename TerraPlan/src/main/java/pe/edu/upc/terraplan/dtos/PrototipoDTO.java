package pe.edu.upc.terraplan.dtos;

import pe.edu.upc.terraplan.entities.Plano;

import java.time.LocalDate;

public class PrototipoDTO {
    private int idPrototipo;
    private String tipoEstructuraPrototipo;
    private String descripcionPrototipo;
    private LocalDate fechaCreacionPrototipo;
    private Plano plano;

    public int getIdPrototipo() {
        return idPrototipo;
    }

    public void setIdPrototipo(int idPrototipo) {
        this.idPrototipo = idPrototipo;
    }

    public String getTipoEstructuraPrototipo() {
        return tipoEstructuraPrototipo;
    }

    public void setTipoEstructuraPrototipo(String tipoEstructuraPrototipo) {
        this.tipoEstructuraPrototipo = tipoEstructuraPrototipo;
    }

    public String getDescripcionPrototipo() {
        return descripcionPrototipo;
    }

    public void setDescripcionPrototipo(String descripcionPrototipo) {
        this.descripcionPrototipo = descripcionPrototipo;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public LocalDate getFechaCreacionPrototipo() {
        return fechaCreacionPrototipo;
    }

    public void setFechaCreacionPrototipo(LocalDate fechaCreacionPrototipo) {
        this.fechaCreacionPrototipo = fechaCreacionPrototipo;
    }
}