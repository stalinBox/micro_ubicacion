package ec.gob.mag.rna.ubicacion.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//============== LOMBOK =============

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

//========== JPA ======================
@Entity
public class UbicacionValidate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonInclude(Include.NON_NULL)
	private Long parroquia_id;
	@JsonInclude(Include.NON_NULL)
	private String parroquia_codigo_inec;
	@JsonInclude(Include.NON_NULL)
	private String parroquia_nombre;
	@JsonInclude(Include.NON_NULL)
	private Long canton_id;
	@JsonInclude(Include.NON_NULL)
	private String canton_codigo_inec;
	@JsonInclude(Include.NON_NULL)
	private String canton_nombre;
	@Id
	@JsonInclude(Include.NON_NULL)
	private Long provincia_id;
	@JsonInclude(Include.NON_NULL)
	private String provincia_codigo_inec;
	@JsonInclude(Include.NON_NULL)
	private String provincia_nombre;
	@JsonInclude(Include.NON_NULL)
	private String x_origen;
	@JsonInclude(Include.NON_NULL)
	private String y_origen;
	@JsonInclude(Include.NON_NULL)
	private Long srid_origen;
	@JsonInclude(Include.NON_NULL)
	private Float x_destino;
	@JsonInclude(Include.NON_NULL)
	private Float y_destino;
	@JsonInclude(Include.NON_NULL)
	private Long srid_destino;
	@JsonInclude(Include.NON_NULL)
	private String hemisferio;
	@JsonInclude(Include.NON_NULL)
	private Long zona;
	@JsonInclude(Include.NON_NULL)
	private String validacion;
}
