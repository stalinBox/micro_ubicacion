package ec.gob.mag.rna.ubicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Localizacion {
	private Integer parrquia_id;
	private String parroquia_codigo_inec;
	private String parroquia_nombre;
	private Integer canton_id;
	private String canton_codigo_inec;
	private String canton_nombre;
	private Integer provincia_id;
	private String provincia_codigo_inec;
	private String provincia_nombre;

	private String x_origen;
	private String y_origen;
	private Integer srid_origen;
	private Double x_destino;
	private Double y_destino;
	private Integer srid_destino;
	private String hemisferio;
	private Integer zona;
}
