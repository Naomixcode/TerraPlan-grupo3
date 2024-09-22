package pe.edu.upc.terraplan.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImplement implements  IMaterialService {
    @Autowired
    private IMaterialRepository materialRepository;

    @Override
    public List<Material> list(){return materialRepository.findAll();}

    @Override
    public void insert(Material material) {
        materialRepository.save(material);
    }

    @Override
    public void delete(int id) {
        materialRepository.deleteById(id);
    }

    @Override
    public void update(Material material) {
        materialRepository.save(material);
    }
}
