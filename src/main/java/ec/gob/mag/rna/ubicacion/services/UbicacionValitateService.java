package ec.gob.mag.rna.ubicacion.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import ec.gob.mag.rna.ubicacion.domain.UbicacionValidate;
import ec.gob.mag.rna.ubicacion.exception.UbicacionNotFoundException;
import ec.gob.mag.rna.ubicacion.repository.UbicacionValidateRepository;

/**
 * Clase UbicacionService.
 *
 * @author PITPPA
 * @version final
 */

@Service("ubicacionValitateService")
public class UbicacionValitateService {
	@Autowired
	@Qualifier("ubicacionValidateRepository")
	private UbicacionValidateRepository ubicacionValidateRepository;
	@Autowired
	private MessageSource messageSource;

	/**
	 * Devuelve todas las ubicaciones
	 *
	 * @return List<UbicacionValidate>
	 */
	public Optional<UbicacionValidate> findCanton_id(Integer ubiId, Double xLong, Double yLat) {
		Optional<UbicacionValidate> ubicaciones = ubicacionValidateRepository.findCanton_id(ubiId, xLong, yLat);
		if (!ubicaciones.isPresent())
			throw new UbicacionNotFoundException(String.format(
					messageSource.getMessage("error.entity_cero_exist.message", null, LocaleContextHolder.getLocale()),
					this.getClass().getName()));

		return ubicaciones;
	}

	/**
	 * Devuelve todas las ubicaciones
	 *
	 * @return List<UbicacionValidate>
	 */
	public Optional<UbicacionValidate> findParroquia_id(Integer ubiId, Double xLong, Double yLat) {
		Optional<UbicacionValidate> ubicaciones = ubicacionValidateRepository.findParroquia_id(ubiId, xLong, yLat);
		if (!ubicaciones.isPresent())
			throw new UbicacionNotFoundException(String.format(
					messageSource.getMessage("error.entity_cero_exist.message", null, LocaleContextHolder.getLocale()),
					this.getClass().getName()));

		return ubicaciones;
	}
}
