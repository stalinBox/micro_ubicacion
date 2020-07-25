package ec.gob.mag.rna.ubicacion.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import ec.gob.mag.rna.ubicacion.domain.UbicacionValidate;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseValidationProcedure {
	@ApiModelProperty(notes = "Resultado de la validación", position = 2)
	@JsonInclude(Include.NON_NULL)
	private Boolean validation;

	@ApiModelProperty(notes = "Objeto con los datos validados", position = 3)
	@JsonInclude(Include.NON_NULL)
	private UbicacionValidate datosValidados;
}
