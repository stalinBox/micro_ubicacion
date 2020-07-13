package ec.gob.mag.rna.ubicacion.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ec.gob.mag.rna.ubicacion.domain.Ubicacion;

@Repository("ubicacionRepository")
public interface UbicacionRepository extends CrudRepository<Ubicacion, Long> {

	List<Ubicacion> findByUbicacion_UbiIdAndUbiEstadoAndUbiEliminadoEquals(Long ubiId, Integer ubiEstado,
			boolean ubiEliminado);

	Optional<Ubicacion> findByUbiIdAndUbiEstadoAndUbiEliminadoEquals(Long ubiId, Integer ubiEstado,
			boolean ubiEliminado);

	List<Ubicacion> findByCatIdUbicacionAndUbiEstadoAndUbiEliminadoEquals(Long catIdUbi, Integer ubiEstado,
			boolean ubiEliminado);

	@Query("SELECT ub FROM Ubicacion ub WHERE ub.ubiEstado=11 and ub.ubiEliminado=false and ub.ubiIdRegion=?1 and ub.ubicacion.ubiId=?2")
	List<Ubicacion> findByUbiIdRegionAndUbicacion(Long ubiId, Long ubiIdPadre);

}
