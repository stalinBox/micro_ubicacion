package ec.gob.mag.rna.ubicacion.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseValidationProcedure {
	@ApiModelProperty(notes = "Resultado de la validación", position = 2)
	private Boolean validation;
	@ApiModelProperty(notes = "Objeto con los datos validados", position = 3)
	private List<Localizacion> datosValidados;
	@ApiModelProperty(notes = "Objeto con los datos validados", position = 3)
	private List<LocalizacionCanton> datosValidadosCanton;
}
