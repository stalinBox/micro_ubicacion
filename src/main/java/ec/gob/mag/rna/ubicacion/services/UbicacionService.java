package ec.gob.mag.rna.ubicacion.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import ec.gob.mag.rna.ubicacion.domain.Ubicacion;
import ec.gob.mag.rna.ubicacion.dto.ResponseProvincias;
import ec.gob.mag.rna.ubicacion.exception.UbicacionNotFoundException;
import ec.gob.mag.rna.ubicacion.repository.UbicacionRepository;

/**
 * Clase UbicacionService.
 *
 * @author PITPPA
 * @version final
 */

@Service("ubicacionService")
public class UbicacionService {
	@Autowired
	@Qualifier("ubicacionRepository")
	private UbicacionRepository ubicacionRepository;
	@Autowired
	private MessageSource messageSource;

	/**
	 * Busca todas las Ubicaciones por ubiId
	 * 
	 * @param Long ubiId
	 *
	 * @return List<Ubicacion>
	 */
	public List<Ubicacion> findChildrenByUbiId(Long ubiId) {
		List<Ubicacion> ubicaciones = ubicacionRepository.findByUbicacion_UbiIdAndUbiEstadoAndUbiEliminadoEquals(ubiId,
				11, false);
		if (ubicaciones.isEmpty())
			throw new UbicacionNotFoundException(String.format(
					messageSource.getMessage("error.entity_cero_exist.message", null, LocaleContextHolder.getLocale()),
					this.getClass().getName()));

		ubicaciones = ubicaciones.stream().map(ubicacion -> {
			ubicacion.setUbicacion(null);
			return ubicacion;
		}).collect(Collectors.toList());

		return ubicaciones;
	}

	/**
	 * Busca una Ubicación por ubiId
	 *
	 * @param Long ubiId
	 *
	 * @return Ubicación, que cumple la condición.
	 */
	public Ubicacion findByUbiId(Long ubiId) {
		Optional<Ubicacion> catalogo = ubicacionRepository.findByUbiIdAndUbiEstadoAndUbiEliminadoEquals(ubiId, 11,
				false);
		if (!catalogo.isPresent())
			throw new UbicacionNotFoundException(String.format(
					messageSource.getMessage("error.entity_not_exist.message", null, LocaleContextHolder.getLocale()),
					ubiId));
		return catalogo.get();
	}

	public List<Ubicacion> findByRegiones(Long catIdUbi) {
		List<Ubicacion> ubicaciones = ubicacionRepository
				.findByCatIdUbicacionAndUbiEstadoAndUbiEliminadoEquals(catIdUbi, 11, false);
		if (ubicaciones.isEmpty())
			throw new UbicacionNotFoundException(String.format(
					messageSource.getMessage("error.entity_cero_exist.message", null, LocaleContextHolder.getLocale()),
					this.getClass().getName()));

		ubicaciones = ubicaciones.stream().map(ubicacion -> {
			ubicacion.setUbicacion(null);
			return ubicacion;
		}).collect(Collectors.toList());

		return ubicaciones;
	}

	public List<ResponseProvincias> findByProvinciasByRegiones(Long ubiId, Long ubiIdPadre) throws IOException {
		List<ResponseProvincias> respPro = new ArrayList<ResponseProvincias>();

		List<Ubicacion> ubicaciones = ubicacionRepository.findByUbiIdRegionAndUbicacion(ubiId, ubiIdPadre);
		if (ubicaciones.isEmpty())
			throw new UbicacionNotFoundException(String.format(
					messageSource.getMessage("error.entity_cero_exist.message", null, LocaleContextHolder.getLocale()),
					this.getClass().getName()));
		ubicaciones = ubicaciones.stream().map(ubicacion -> {
			ResponseProvincias prov = new ResponseProvincias();
			prov.setCatIdUbicacion(ubicacion.getCatIdUbicacion());
			prov.setUbiId(ubicacion.getUbiId());
			prov.setUbiNombre(ubicacion.getUbiNombre());
			ubicacion.setUbicacion(null);
			respPro.add(prov);
			return ubicacion;
		}).collect(Collectors.toList());

		return respPro;
	}

}
