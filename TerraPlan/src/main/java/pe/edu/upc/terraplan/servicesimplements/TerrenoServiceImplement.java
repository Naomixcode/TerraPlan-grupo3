package pe.edu.upc.terraplan.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.terraplan.entities.Terreno;
import pe.edu.upc.terraplan.repositories.ITerrenoRepository;
import pe.edu.upc.terraplan.servicesinterfaces.ITerrenoService;

import java.util.List;

@Service
public class TerrenoServiceImplement implements ITerrenoService {
    @Autowired
    private ITerrenoRepository terrenoRepository;

    @Override
    public List<Terreno> list(){return terrenoRepository.findAll();}

    @Override
    public void insert(Terreno terreno) {
        terrenoRepository.save(terreno);
    }

    @Override
    public void delete(int id) {
        terrenoRepository.deleteById(id);
    }

    @Override
    public void update(Terreno terreno) {
        terrenoRepository.save(terreno);
    }

    @Override
    public List<String[]> CantidadTerrenosUbicaicon() {
        return terrenoRepository.cantidadTerrenosUbicacion();
    }


}

