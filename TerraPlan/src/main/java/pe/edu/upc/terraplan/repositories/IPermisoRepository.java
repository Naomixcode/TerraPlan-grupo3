package pe.edu.upc.si62_grupo_01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.si62_grupo_01.entities.Permiso;

@Repository
public interface IPermisoRepository extends JpaRepository<Permiso,Integer> {
}
