package ec.gob.mag.rna.ubicacion.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "ubicacion", schema = "public")
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="ord", scope = Agrupacion.class)
public class ResponseProvincias implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Este campo es  la clave primaria de la tabla agrupacion")
	@Id
	@Column(name = "ubi_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("ubiId")
	private Long ubiId;

	@ApiModelProperty(value = " ***", position = 3)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "cat_id_ubicacion")
	@JsonProperty("catIdUbicacion")
	private Long catIdUbicacion;

	@ApiModelProperty(value = " ***", position = 9)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_nombre")
	@JsonProperty("ubiNombre")
	private String ubiNombre;
}
