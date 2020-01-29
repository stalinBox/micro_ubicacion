package ec.gob.mag.rna.ubicacion.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.mag.rna.ubicacion.domain.Ubicacion;
import ec.gob.mag.rna.ubicacion.dto.ResponseProvincias;
import ec.gob.mag.rna.ubicacion.services.UbicacionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api")
@Api(value = "Ubicacion", description = "Microservicio de Ubicacion", tags = "UBICACION")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Objeto recuperado"),
		@ApiResponse(code = 201, message = "Objeto creado"),
		@ApiResponse(code = 404, message = "Recurso no encontrado") })
public class MicroUbicacionController implements ErrorController {
	private static final String PATH = "/error";

	public static final Logger LOGGER = LoggerFactory.getLogger(MicroUbicacionController.class);
	@Autowired
	@Qualifier("ubicacionService")
	private UbicacionService ubicacionService;

	@RequestMapping(value = "/ubicacion/findByUbiId/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtiene los datos de la ubicacion y de todos sus ubicaciones padre por id", response = Ubicacion.class)
	@ResponseStatus(HttpStatus.OK)
	public Ubicacion getUbicacion(@PathVariable Long id, @RequestHeader(name = "Authorization") String token) {
		Ubicacion ubicaciones = ubicacionService.findByUbiId(id);
		return ubicaciones;
	}

	@RequestMapping(value = "/ubicacion/findOnlyFirstLevelByUbiId/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtiene únicamente los datos de la ubicacion por Id", response = Ubicacion.class)
	@ResponseStatus(HttpStatus.OK)
	public Ubicacion getUbicacionOnlyFirstLevel(@PathVariable Long id,
			@RequestHeader(name = "Authorization") String token) {
		Ubicacion ubicaciones = ubicacionService.findByUbiId(id);
		ubicaciones.setUbicacion(null);
		return ubicaciones;
	}

	@RequestMapping(value = "/ubicacion/findChildrenByUbiId/{ubiId}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtiene las ubicaciones hijas", response = Ubicacion.class)
	@ResponseStatus(HttpStatus.OK)
	public List<Ubicacion> findChildrenByUbiId(@PathVariable Long ubiId,
			@RequestHeader(name = "Authorization") String token) {
		List<Ubicacion> ubicaciones = ubicacionService.findChildrenByUbiId(ubiId);
		return ubicaciones;
	}

	/**
	 * RENAGRO
	 */

	@RequestMapping(value = "/ubicacion/findByRegiones/{catIdUbi}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtiene todas las regiones, se tiene que enviar el parametro cat_id_ubicacion", response = Ubicacion.class)
	@ResponseStatus(HttpStatus.OK)
	public List<Ubicacion> findByRegiones(@PathVariable Long catIdUbi,
			@RequestHeader(name = "Authorization") String token) {
		List<Ubicacion> ubicaciones = ubicacionService.findByRegiones(catIdUbi);
		return ubicaciones;
	}

	@RequestMapping(value = "/ubicacion/findByProvinciasByRegiones/{ubiIdRegion}/{ubiIdPadre}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtiene las provincias segun la región", response = Ubicacion.class)
	@ResponseStatus(HttpStatus.OK)
	public List<ResponseProvincias> findByProvinciasByRegiones(@PathVariable Long ubiIdRegion,
			@PathVariable Long ubiIdPadre, @RequestHeader(name = "Authorization") String token) throws IOException {
		List<ResponseProvincias> ubicaciones = ubicacionService.findByProvinciasByRegiones(ubiIdRegion, ubiIdPadre);
		return ubicaciones;
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}

}
