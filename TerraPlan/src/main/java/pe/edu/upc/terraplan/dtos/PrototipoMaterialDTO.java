package pe.edu.upc.terraplan.dtos;

public class PrototipoMaterialDTO {
    private  int PrototipoMaterialId;
    private Prototipo prototipo;
    private Material material;

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Prototipo getPrototipo() {
        return prototipo;
    }

    public void setPrototipo(Prototipo prototipo) {
        this.prototipo = prototipo;
    }

    public int getPrototipoMaterialId() {
        return PrototipoMaterialId;
    }

    public void setPrototipoMaterialId(int prototipoMaterialId) {
        PrototipoMaterialId = prototipoMaterialId;
    }
}

