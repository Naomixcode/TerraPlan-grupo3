package pe.edu.upc.terraplan.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PrototipoMaterial")
public class PrototipoMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int PrototipoMaterialId;
    @ManyToOne
    @JoinColumn(name = "idPrototipo")
    private Prototipo prototipo;
    @ManyToOne
    @JoinColumn(name = "idMaterial")
    private Material material;

    public PrototipoMaterial() {
    }

    public PrototipoMaterial(int prototipoMaterialId, Material material, Prototipo prototipo) {
        PrototipoMaterialId = prototipoMaterialId;
        this.material = material;
        this.prototipo = prototipo;
    }

    public int getPrototipoMaterialId() {
        return PrototipoMaterialId;
    }

    public void setPrototipoMaterialId(int prototipoMaterialId) {
        PrototipoMaterialId = prototipoMaterialId;
    }

    public Prototipo getPrototipo() {
        return prototipo;
    }

    public void setPrototipo(Prototipo prototipo) {
        this.prototipo = prototipo;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
