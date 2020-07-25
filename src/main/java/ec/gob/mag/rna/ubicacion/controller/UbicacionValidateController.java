package ec.gob.mag.rna.ubicacion.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import ec.gob.mag.rna.ubicacion.domain.UbicacionValidate;
import ec.gob.mag.rna.ubicacion.dto.ResponseValidationProcedure;
import ec.gob.mag.rna.ubicacion.services.UbicacionValitateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/procedure")
@Api(value = "RNA", description = "Enlace con microservicios del RNA", tags = "PROCEDURES")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Objeto recuperado"),
		@ApiResponse(code = 201, message = "Objeto creado"),
		@ApiResponse(code = 404, message = "Recurso no encontrado") })
public class UbicacionValidateController implements ErrorController {
	private static final String PATH = "/error";
	public static final Logger LOGGER = LoggerFactory.getLogger(UbicacionValidateController.class);

	@Autowired
	@Qualifier("ubicacionValitateService")
	private UbicacionValitateService ubicacionValitateService;

	@RequestMapping(value = "/coordenada/findValidateUbicationParroquia/{ubiId}/{xLong}/{yLat}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca y valida una ubicacion y coordenada para parroquias", response = ResponseValidationProcedure.class)
	@ResponseStatus(HttpStatus.OK)
	public ResponseValidationProcedure findValidateUbicationParroquia(@PathVariable Integer ubiId,
			@PathVariable Double xLong, @PathVariable Double yLat,
			@RequestHeader(name = "Authorization") String token) {
		Optional<UbicacionValidate> datosValidacion = ubicacionValitateService.findParroquia_id(ubiId, xLong, yLat);
		return new ResponseValidationProcedure(true, datosValidacion.get());
	}

	@RequestMapping(value = "/coordenada/findValidateUbicationCanton/{ubiId}/{xLong}/{yLat}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca y valida una ubicacion y coordenada para Cantones", response = ResponseValidationProcedure.class)
	@ResponseStatus(HttpStatus.OK)
	public ResponseValidationProcedure findValidateUbicationCanton(@PathVariable Integer ubiId,
			@PathVariable String xLong, @PathVariable String yLat,
			@RequestHeader(name = "Authorization") String token) {
		Optional<UbicacionValidate> datosValidacion = ubicacionValitateService.findCanton_id(ubiId,
				Double.parseDouble(xLong), Double.parseDouble(yLat));
		return new ResponseValidationProcedure(true, datosValidacion.get());
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

}