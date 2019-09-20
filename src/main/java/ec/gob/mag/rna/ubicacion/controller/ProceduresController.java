package ec.gob.mag.rna.ubicacion.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.mag.rna.ubicacion.dto.Localizacion;
import ec.gob.mag.rna.ubicacion.dto.ResponseValidationProcedure;
import ec.gob.mag.rna.ubicacion.services.ProcedureService;
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
public class ProceduresController implements ErrorController {
	private static final String PATH = "/error";
	public static final Logger LOGGER = LoggerFactory.getLogger(ProceduresController.class);

	@Autowired
	@Qualifier("procedureService")
	private ProcedureService procedureService;

	@RequestMapping(value = "/coordenada/findValidateUbication/{ubiId}/{xLong}/{yLat}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca y valida una ubicacion y coordenada ", response = ResponseValidationProcedure.class)
	@ResponseStatus(HttpStatus.OK)
	public ResponseValidationProcedure findValidateUbication(@PathVariable Integer ubiId, @PathVariable Double xLong,
			@PathVariable Double yLat) {
		List<Localizacion> datosValidacion = null;
		Boolean valido = true;
		valido = procedureService.validarCoordenada(ubiId, xLong, yLat);
		if (valido != false) {
			datosValidacion = procedureService.findPlace(ubiId, xLong, yLat);
		} else {
			valido = false;
		}
		return new ResponseValidationProcedure("validar_coordenadas", valido, datosValidacion);
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

}