package ec.gob.mag.rna.ubicacion.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(of = "paisUbiId")
@EqualsAndHashCode(of = "paisUbiId")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vw_ubicaciones_ecuador", schema = "public")
@Immutable
public class ViewUbicacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Codigo del pais", allowableValues = "")
	@Column(name = "pais_ubi_id")
	@JsonProperty("paisUbiId")
	@JsonInclude(Include.NON_NULL)
	private Long paisUbiId;

	@ApiModelProperty(value = "codigo INEC del pais", allowableValues = "")
	@Column(name = "pais_ubi_cod_inec")
	@JsonProperty("paisUbiCodInec")
	@JsonInclude(Include.NON_NULL)
	private String paisUbiCodInec;

	@ApiModelProperty(value = "Nombre de pais", allowableValues = "")
	@Column(name = "pais_ubi_nombre")
	@JsonProperty("paisUbiNombre")
	@JsonInclude(Include.NON_NULL)
	private String paisUbiNombre;

	// PROVINCIA
	@ApiModelProperty(value = "Codigo de la provincia", allowableValues = "")
	@Column(name = "provincia_ubi_id")
	@JsonProperty("provinciaUbiId")
	@JsonInclude(Include.NON_NULL)
	private Long provinciaUbiId;

	@ApiModelProperty(value = "codigo del padre", allowableValues = "")
	@Column(name = "provincia_ubi_id_padre")
	@JsonProperty("provinciaUbiIdPadre")
	@JsonInclude(Include.NON_NULL)
	private Long provinciaUbiIdPadre;

	@ApiModelProperty(value = "Codigo INEC de la provincia", allowableValues = "")
	@Column(name = "provincia_ubi_cod_inec")
	@JsonProperty("provinciaUbiCodInec")
	@JsonInclude(Include.NON_NULL)
	private String provinciaUbiCodInec;

	@ApiModelProperty(value = "Nombre de la provincia", allowableValues = "")
	@Column(name = "provincia_ubi_nombre")
	@JsonProperty("provinciaUbiNombre")
	@JsonInclude(Include.NON_NULL)
	private String provinciaUbiNombre;

	// CANTON
	@ApiModelProperty(value = "Codigo del canton", allowableValues = "")
	@Column(name = "canton_ubi_id")
	@JsonProperty("cantonUbiId")
	@JsonInclude(Include.NON_NULL)
	private Long cantonUbiId;

	@ApiModelProperty(value = "Ubicacion Padre del canton", allowableValues = "")
	@Column(name = "canton_ubi_id_padre")
	@JsonProperty("cantonUbiIdPadre")
	@JsonInclude(Include.NON_NULL)
	private Long cantonUbiIdPadre;

	@ApiModelProperty(value = "Codigo INEC del canton", allowableValues = "")
	@Column(name = "canton_ubi_cod_inec")
	@JsonProperty("cantonUbiCodInec")
	@JsonInclude(Include.NON_NULL)
	private String cantonUbiCodInec;

	@ApiModelProperty(value = "Nombre del canton", allowableValues = "")
	@Column(name = "canton_ubi_nombre")
	@JsonProperty("cantonUbiNombre")
	@JsonInclude(Include.NON_NULL)
	private String cantonUbiNombre;

	// PARROQUIA
	@Id
	@ApiModelProperty(value = "Codigo de la parroquia", allowableValues = "")
	@Column(name = "parroquia_ubi_id")
	@JsonProperty("parroquiaUbiId")
	@JsonInclude(Include.NON_NULL)
	private Long parroquiaUbiId;

	@ApiModelProperty(value = "Codigo padre de la parroquia", allowableValues = "")
	@Column(name = "parroquia_ubi_id_padre")
	@JsonProperty("parroquiaUbiIdPadre")
	@JsonInclude(Include.NON_NULL)
	private Long parroquiaUbiIdPadre;

	@ApiModelProperty(value = "Codigo INEC de la parroquia", allowableValues = "")
	@Column(name = "parroquia_ubi_cod_inec")
	@JsonProperty("parroquiaUbiCodInec")
	@JsonInclude(Include.NON_NULL)
	private String parroquiaUbiCodInec;

	@ApiModelProperty(value = "Nombre de la parroquia", allowableValues = "")
	@Column(name = "parroquia_ubi_nombre")
	@JsonProperty("parroquiaUbiNombre")
	@JsonInclude(Include.NON_NULL)
	private String parroquiaUbiNombre;
}
