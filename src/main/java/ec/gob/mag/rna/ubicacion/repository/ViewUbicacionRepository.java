package ec.gob.mag.rna.ubicacion.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.gob.mag.rna.ubicacion.domain.ViewUbicacion;

@Repository("viewUbicacionRepository")
public interface ViewUbicacionRepository extends CrudRepository<ViewUbicacion, Long> {

	@Query("FROM ViewUbicacion")
	List<ViewUbicacion> findAll();

	Optional<ViewUbicacion> findByParroquiaUbiId(Long idParroquia);
}
