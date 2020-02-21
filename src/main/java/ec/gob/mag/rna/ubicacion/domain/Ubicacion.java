package ec.gob.mag.rna.ubicacion.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//============== LOMBOK =============

@Getter
@Setter
@ToString(of = "ubiId")
@EqualsAndHashCode(of = "ubiId")
@NoArgsConstructor
@AllArgsConstructor
@Builder

//========== JPA ======================

@Entity
@Table(name = "ubicacion", schema = "sc_geografico")
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="ord", scope = Agrupacion.class)
public class Ubicacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4017650183258693515L;

	@ApiModelProperty(value = "Este campo es  la clave primaria de la tabla agrupacion")
	@Id
	@Column(name = "ubi_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("ubiId")
	private Long ubiId;

	@ApiModelProperty(value = " ***", position = 2)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "cat_id_sector")
	@JsonProperty("catIdSector")
	private Long catIdSector;

	@ApiModelProperty(value = " ***", position = 3)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "cat_id_ubicacion")
	@JsonProperty("catIdUbicacion")
	private Long catIdUbicacion;

	@ApiModelProperty(value = " ***", position = 4)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "cat_id_capital")
	@JsonProperty("catIdCapital")
	private Long catIdCapital;

	@ApiModelProperty(value = " ***", position = 5)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "cat_id_zona")
	@JsonProperty("catIdZona")
	private Long catIdZona;

	@ApiModelProperty(value = " ***", position = 6)
	@JsonInclude(Include.NON_NULL)

	@OneToOne(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "ubi_id_padre", insertable = false, updatable = false)
	@JsonProperty("ubicacion")
	private Ubicacion ubicacion;

	@ApiModelProperty(value = " ***", position = 7)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_cod_inec")
	@JsonProperty("ubiCodInec")
	private String ubiCodInec;

	@ApiModelProperty(value = " ***", position = 8)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_canton")
	@JsonProperty("ubiCanton")
	private String ubiCanton;

	@ApiModelProperty(value = " ***", position = 9)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_nombre")
	@JsonProperty("ubiNombre")
	private String ubiNombre;

	@ApiModelProperty(value = " ***", position = 10)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_nivel")
	@JsonProperty("ubiNivel")
	private int ubiNivel;

	@ApiModelProperty(value = " ***", position = 11)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_prefijo_tel")
	@JsonProperty("ubiPrefijoTel")
	private String ubiPrefijoTel;

	@ApiModelProperty(value = " ***", position = 12)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_estado")
	@JsonProperty("ubiEstado")
	private int ubiEstado;

	@ApiModelProperty(value = " ***", position = 13)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_eliminado")
	@JsonProperty("ubiEliminado")
	private Boolean ubiEliminado;

	@ApiModelProperty(value = " ***", position = 14)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_reg_usu")
	@JsonProperty("ubiRegUsu")
	private Long ubiRegUsu;
	/*
	 *
	 * Pasar a timesatmp
	 */
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@ApiModelProperty(value = " ***", position = 15)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_reg_fecha", updatable = false)
	@JsonProperty("ubiRegFecha")
	private Date ubiRegFecha;

	@ApiModelProperty(value = " ***", position = 16)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_act_usu")
	@JsonProperty("ubiActUsu")
	private Long ubiActUsu;
	// ---

	@ApiModelProperty(value = " ***", position = 17)
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_act_fecha")
	@JsonProperty("ubiActFecha")
	private Date ubiActFecha;

	@ApiModelProperty(value = " ***", position = 18)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_latitud")
	@JsonProperty("ubiLatitud")
	private Float ubiLatitud;

	@ApiModelProperty(value = " ***", position = 19)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_longitud")
	@JsonProperty("ubiLongitud")
	private Float ubiLongitud;

	@ApiModelProperty(value = " ***", position = 20)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_superficie")
	@JsonProperty("ubiSuperficie")
	private Float ubiSuperficie;

	@ApiModelProperty(value = " ***", position = 21)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_longitud_min")
	@JsonProperty("ubiLongitudMin")
	private Float ubiLongitudMin;

	@ApiModelProperty(value = " ***", position = 22)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_longitud_max")
	@JsonProperty("ubiLongitudMax")
	private Float ubiLongitudMax;

	@ApiModelProperty(value = " ***", position = 23)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_latitud_max")
	@JsonProperty("ubiLatitudMax")
	private Float ubiLatitudMax;
	/*
	 * @ApiModelProperty(value = " ***", position = 24)
	 * 
	 * @JsonInclude(Include.NON_NULL)
	 * 
	 * @Column(name = "ubi_poligono_17",columnDefinition = "geometry(Polygon,3217)")
	 * //@Type(type = "com.vividsolutions.jts.geom.Geometry")
	 * 
	 * @JsonProperty("ubiPoligono17")
	 * 
	 * private Geometry ubiPoligono17;
	 */

	/*
	 * @ApiModelProperty(value = " ***", position = 25)
	 * 
	 * @JsonInclude(Include.NON_NULL)
	 * 
	 * @Column(name="ubi_poligono_15")
	 * 
	 * @JsonProperty("ubiPoligono15") private Geometry ubiPoligono15;
	 * 
	 */

	@ApiModelProperty(value = " ***", position = 26)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_zona")
	@JsonProperty("ubiZona")
	private String ubiZona;

	@ApiModelProperty(value = " ***", position = 27)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_hemisferio")
	@JsonProperty("ubiHemisferio")
	private String ubiHemisferio;

	@ApiModelProperty(value = " ***", position = 28)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_x_min_17s")
	@JsonProperty("ubiXMin17s")
	private Float ubiXMin17s;

	@ApiModelProperty(value = " ***", position = 29)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_x_max_17s")
	@JsonProperty("ubiXMax17s")
	private Float ubiXMax17s;

	@ApiModelProperty(value = " ***", position = 30)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_y_min_17s")
	@JsonProperty("ubiYMin17s")
	private Float ubiYMin17s;

	@ApiModelProperty(value = " ***", position = 31)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_y_max_17s")
	@JsonProperty("ubiYMax17s")
	private Float ubiYMax17s;

	@ApiModelProperty(value = " ***", position = 32)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_latitud_min")
	@JsonProperty("ubiLatitudMin")
	private Float ubiLatitudMin;

	@ApiModelProperty(value = " ***", position = 33)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_x_17s")
	@JsonProperty("ubiX17s")
	private Float ubiX17s;

	@ApiModelProperty(value = " ***", position = 34)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_y_17s")
	@JsonProperty("ubiY17s")
	private Float ubiY17s;

	@ApiModelProperty(value = " ***", position = 35)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_x_17n")
	@JsonProperty("ubiX17n")
	private Float ubiX17n;

	@ApiModelProperty(value = " ***", position = 36)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_y_17n")
	@JsonProperty("ubiY17n")
	private Float ubiY17n;

	@ApiModelProperty(value = " ***", position = 37)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_x_18s")
	@JsonProperty("ubiX18s")
	private Float ubiX18s;

	@ApiModelProperty(value = " ***", position = 38)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_y_18s")
	@JsonProperty("ubiY18s")
	private Float ubiY18s;

	@ApiModelProperty(value = " ***", position = 39)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_x_18n")
	@JsonProperty("ubiX18n")
	private Float ubiX18n;

	@ApiModelProperty(value = " ***", position = 40)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_y_18n")
	@JsonProperty("ubiY18n")
	private Float ubiY18n;

	@ApiModelProperty(value = " ***", position = 41)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_x_max_17n")
	@JsonProperty("ubiXMax17n")
	private Float ubiXMax17n;

	@ApiModelProperty(value = " ***", position = 42)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_x_min_17n")
	@JsonProperty("ubiXMin17n")
	private Float ubiXMin17n;

	@ApiModelProperty(value = " ***", position = 43)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_y_max_17n")
	@JsonProperty("ubiYMax17n")
	private Float ubiYMax17n;

	@ApiModelProperty(value = " ***", position = 44)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_y_min_17n")
	@JsonProperty("ubiYMin17n")
	private Float ubiYMin17n;

	@ApiModelProperty(value = " ***", position = 45)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_x_max_18s")
	@JsonProperty("ubiXMax18s")
	private Float ubiXMax18s;

	@ApiModelProperty(value = " ***", position = 46)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_x_min_18s")
	@JsonProperty("ubiXMin18s")
	private Float ubiXMin18s;

	@ApiModelProperty(value = " ***", position = 47)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_y_max_18s")
	@JsonProperty("ubiYMax18s")
	private Float ubiYMax18s;

	@ApiModelProperty(value = " ***", position = 48)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_y_min_18s")
	@JsonProperty("ubiYMin18s")
	private Float ubiYMin18s;

	@ApiModelProperty(value = " ***", position = 49)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_x_max_18n")
	@JsonProperty("ubiXMax18n")
	private Float ubiXMax18n;

	@ApiModelProperty(value = " ***", position = 50)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_x_min_18n")
	@JsonProperty("ubiXMin18n")
	private Float ubiXMin18n;

	@ApiModelProperty(value = " ***", position = 51)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_y_max_18n")
	@JsonProperty("ubiYMax18n")
	private Float ubiYMax18n;

	@ApiModelProperty(value = " ***", position = 52)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_y_min_18n")
	@JsonProperty("ubiYMin18n")
	private Float ubiYMin18n;

	/**
	 * AGREGADO PARA CONSULTAR LAS REGIONES EN RENAGRO
	 */
	@ApiModelProperty(value = " ***", position = 16)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ubi_id_region")
	@JsonProperty("ubiIdRegion")
	private Long ubiIdRegion;

	@PrePersist
	public void prePersist() {
		// this.timeStamp = Util.dateNow();
		this.ubiEstado = 11;
		this.ubiEliminado = false;
	}
}
