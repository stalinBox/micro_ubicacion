package ec.gob.mag.rna.ubicacion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.mag.rna.ubicacion.domain.UbicacionValidate;

@Repository("ubicacionValidateRepository")
public interface UbicacionValidateRepository extends CrudRepository<UbicacionValidate, Long> {

	@Query(value = "SELECT \n" + "null parroquia_id ,\n" + "null parroquia_codigo_inec ,\n"
			+ "null parroquia_nombre , \n" + "out_canton_id canton_id, \n"
			+ "out_canton_codigo_inec canton_codigo_inec, \n" + "out_canton_nombre canton_nombre, \n"
			+ "out_provincia_id provincia_id, \n" + "out_provincia_codigo_inec provincia_codigo_inec,\n"
			+ "out_provincia_nombre provincia_nombre, \n" + "out_x_origen x_origen, \n" + "out_y_origen y_origen, \n"
			+ "out_srid_origen srid_origen, \n" + "out_x_destino x_destino, \n" + "out_y_destino y_destino, \n"
			+ "out_srid_destino srid_destino,\n" + "out_hemisferio hemisferio, \n" + "out_zona zona,\n"
			+ "out_validacion validacion\n" + "FROM \n" + "(\n" + "SELECT *\n"
			+ "FROM sc_geografico.sp_valida_punto_geografico_canton(:ubiId,:xLong,:yLat)\n"
			+ ") consulta;", nativeQuery = true)
	Optional<UbicacionValidate> findCanton_id(@Param("ubiId") Integer ubiId, @Param("xLong") Double xLong,
			@Param("yLat") Double yLat);

	@Query(value = "SELECT \n" + "out_parroquia_id parroquia_id, \n"
			+ "out_parroquia_codigo_inec parroquia_codigo_inec, \n" + "out_parroquia_nombre parroquia_nombre, \n"
			+ "out_canton_id canton_id, \n" + "out_canton_codigo_inec canton_codigo_inec, \n"
			+ "out_canton_nombre canton_nombre, \n" + "out_provincia_id provincia_id, \n"
			+ "out_provincia_codigo_inec provincia_codigo_inec,\n" + "out_provincia_nombre provincia_nombre, \n"
			+ "out_x_origen x_origen, \n" + "out_y_origen y_origen, \n" + "out_srid_origen srid_origen, \n"
			+ "out_x_destino x_destino, \n" + "out_y_destino y_destino, \n" + "out_srid_destino srid_destino,\n"
			+ "out_hemisferio hemisferio, \n" + "out_zona zona,\n" + "out_validacion validacion\n" + "FROM \n" + "(\n"
			+ "SELECT *\n" + "FROM sc_geografico.sp_valida_punto_geografico_parroquia(:ubiId,:xLong,:yLat)\n"
			+ ") consulta;", nativeQuery = true)
	Optional<UbicacionValidate> findParroquia_id(@Param("ubiId") Integer ubiId, @Param("xLong") Double xLong,
			@Param("yLat") Double yLat);
}
