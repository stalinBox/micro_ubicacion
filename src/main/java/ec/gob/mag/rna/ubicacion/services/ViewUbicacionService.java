package ec.gob.mag.rna.ubicacion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import ec.gob.mag.rna.ubicacion.domain.ViewUbicacion;
import ec.gob.mag.rna.ubicacion.exception.UbicacionNotFoundException;
import ec.gob.mag.rna.ubicacion.repository.ViewUbicacionRepository;

@Service("viewUbicacionService")
public class ViewUbicacionService {

	@Autowired
	@Qualifier("viewUbicacionRepository")
	private ViewUbicacionRepository viewUbicacionRepository;

	@Autowired
	private MessageSource messageSource;

	/**
	 * Devuelve todas las ubicaciones
	 *
	 * @return List<Ubicacion>
	 */
	public List<ViewUbicacion> findAll() {
		List<ViewUbicacion> ubicaciones = viewUbicacionRepository.findAll();
		if (ubicaciones.isEmpty())
			throw new UbicacionNotFoundException(String.format(
					messageSource.getMessage("error.entity_cero_exist.message", null, LocaleContextHolder.getLocale()),
					this.getClass().getName()));

		return ubicaciones;
	}

	/**
	 * Devuelve todas las ubicaciones
	 *
	 * @return List<Ubicacion>
	 */
	public Optional<ViewUbicacion> findByParroquiaUbiId(Long idParroquia) {
		Optional<ViewUbicacion> ubicaciones = viewUbicacionRepository.findByParroquiaUbiId(idParroquia);
		if (!ubicaciones.isPresent())
			throw new UbicacionNotFoundException(String.format(
					messageSource.getMessage("error.entity_cero_exist.message", null, LocaleContextHolder.getLocale()),
					this.getClass().getName()));

		return ubicaciones;
	}
}
