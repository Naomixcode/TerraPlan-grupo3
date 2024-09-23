package pe.edu.upc.si62_grupo_01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.si62_grupo_01.entities.PrototipoMaterial;

import java.util.List;

@Repository
public interface IPrototipoMaterialRepository extends JpaRepository<PrototipoMaterial, Integer> {


}