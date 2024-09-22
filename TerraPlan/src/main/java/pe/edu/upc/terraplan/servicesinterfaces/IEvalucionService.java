package pe.edu.upc.terraplan.servicesinterfaces;

import pe.edu.upc.si62_grupo_01.entities.Evaluacion;

import java.util.List;

public interface IEvaluacionService {
    public List<Evaluacion> list();
    public void insert(Evaluacion evaluacion);
    public void update(Evaluacion evaluacion);
    public void delete(int id);

}
