package ec.gob.mag.rna.ubicacion.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import ec.gob.mag.rna.ubicacion.domain.Ubicacion;
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
	 * Devuelve todas las ubicaciones  
	 *
	 * @return List<Ubicacion>
	 */
	public List<Ubicacion> findAll() {
		List<Ubicacion> ubicaciones = ubicacionRepository.findAll();
		if (ubicaciones.isEmpty())
			throw new UbicacionNotFoundException(String.format(
					messageSource.getMessage("error.entity_cero_exist.message", null, LocaleContextHolder.getLocale()),
					this.getClass().getName()));

		return ubicaciones;
	}

	/**
	 * Busca todas las Ubicaciones  por ubiId
	 * 
	 * @param Long ubiId
	 *
	 * @return List<Ubicacion>
	 */
	public List<Ubicacion> findChildrenByUbiId(Long ubiId) {
		List<Ubicacion> ubicaciones = ubicacionRepository.findByUbicacion_UbiId(ubiId);
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
		Optional<Ubicacion> catalogo = ubicacionRepository.findByUbiId(ubiId);
		if (!catalogo.isPresent())
			throw new UbicacionNotFoundException(String.format(
					messageSource.getMessage("error.entity_not_exist.message", null, LocaleContextHolder.getLocale()),
					ubiId));
		return catalogo.get();
	}

	/**
	 * Crea una nueva Ubicación
	 * 
	 * @param Ubicacion catalogo
	 *
	 * @return List<Ubicacion>
	 */
	public Ubicacion save(Ubicacion catalogo) {
		return ubicacionRepository.save(catalogo);
	}
	/**
	 * Elimina una ubicación de acuerdo a un ID
	 *
	 * @param Long cobId
	 */
	public void deleteById(Long cobId) {
		ubicacionRepository.deleteById(cobId);
	}
}
