package pe.edu.upc.terraplan.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import pe.edu.upc.terraplan.entities.Proyecto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TerrenoDTO {
    private int idTerreno;
    private  String ubicacionTerreno;
    private float tamanioTerreno;
    private String descripcionTerreno;
    private Proyecto proyecto;


    public int getIdTerreno() {
        return idTerreno;
    }

    public void setIdTerreno(int idTerreno) {
        this.idTerreno = idTerreno;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public float getTamanioTerreno() {
        return tamanioTerreno;
    }

    public void setTamanioTerreno(float tamanioTerreno) {
        this.tamanioTerreno = tamanioTerreno;
    }

    public String getDescripcionTerreno() {
        return descripcionTerreno;
    }

    public void setDescripcionTerreno(String descripcionTerreno) {
        this.descripcionTerreno = descripcionTerreno;
    }

    public String getUbicacionTerreno() {
        return ubicacionTerreno;
    }

    public void setUbicacionTerreno(String ubicacionTerreno) {
        this.ubicacionTerreno = ubicacionTerreno;
    }
}
