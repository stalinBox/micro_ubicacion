package ec.gob.mag.rna.ubicacion.repository;


import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ec.gob.mag.rna.ubicacion.domain.Ubicacion;


@Repository("ubicacionRepository")
public interface UbicacionRepository extends CrudRepository<Ubicacion, Long> {
 
	List<Ubicacion> findAll();
	
	List<Ubicacion> findByUbicacion_UbiId(Long ubiId);
	
	Optional<Ubicacion> findByUbiId(Long ubiId);
	

	Ubicacion save(Ubicacion agrupacion);

	void deleteByUbiId(Integer ubiId);

}
