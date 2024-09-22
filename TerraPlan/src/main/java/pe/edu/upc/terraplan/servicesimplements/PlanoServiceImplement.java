package pe.edu.upc.terraplan.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class PlanoServiceImplement {
    @Service
    public class PlanoServiceImplement implements IPlanoService {

        @Autowired
        private IPlanoRepository planoRepository;

        @Override
        public List<Plano> list() {
            return planoRepository.findAll();
        }

        @Override
        public void insert(Plano plano) {
            planoRepository.save(plano);
        }

        @Override
        public void update(Plano plano) {
            planoRepository.save(plano);
        }

        @Override
        public void delete(int id) {
            planoRepository.deleteById(id);
        }
    }
}
