package ec.gob.mag.rna.ubicacion.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.Output;
import org.hibernate.result.ResultSetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.mag.rna.ubicacion.dto.Localizacion;

/**
 * Clase ProcedureService.
 *
 * @author PITPPA
 * @version final
 */

@Service("procedureService")
public class ProcedureService {

	private final EntityManager entityManager;

	@Autowired
	public ProcedureService(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Valida que las coordenadas ingresadas son correctas.
	 *
	 * @param Integer ubiId
	 * @param Double  x
	 * @param Double  y
	 * @return Boolean, true si son correctas, caso contario, false.
	 */
	public Boolean validarCoordenada(Integer ubiId, Double x, Double y) {
		StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("public.validar_lat_long");
		// Registrar los parámetros dfindPlacee entrada y salida
		storedProcedureQuery.registerStoredProcedureParameter("ubiId", Integer.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("x", Double.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("y", Double.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("res", Boolean.class, ParameterMode.OUT);
		storedProcedureQuery.setParameter("ubiId", ubiId);
		storedProcedureQuery.setParameter("x", x);
		storedProcedureQuery.setParameter("y", y);
		storedProcedureQuery.execute();
		final Boolean res = (Boolean) storedProcedureQuery.getOutputParameterValue("res");
		return res;
	}

	/**
	 * Valida el punto geográfico
	 *
	 * @param Integer ubiId
	 * @param Double  longitud
	 * @param Double  latitud
	 * @return List<Localizacion>.
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Localizacion> findPlace(Integer ubiId, Double longitud, Double latitud) {
		Session session = entityManager.unwrap(Session.class);
		ProcedureCall call = session.createStoredProcedureCall("public.sp_valida_punto_geografico");
		call.registerParameter(1, void.class, ParameterMode.REF_CURSOR);
		call.registerParameter(2, Integer.class, ParameterMode.IN).bindValue(ubiId);
		call.registerParameter(3, Double.class, ParameterMode.IN).bindValue(longitud);
		call.registerParameter(4, Double.class, ParameterMode.IN).bindValue(latitud);
		Output output = call.getOutputs().getCurrent();

		List<Localizacion> localizaciones = new ArrayList<>();
		if (output.isResultSet()) {
			List<Object[]> resultSet = ((ResultSetOutput) output).getResultList();
			localizaciones = resultSet.stream().map(r -> {
				Localizacion loc = new Localizacion((Integer) r[0], (String) r[1], (String) r[2], (Integer) r[3],
						(String) r[4], (String) r[5], (Integer) r[6], (String) r[7], (String) r[8], (String) r[9],
						(String) r[10], (Integer) r[11], (Double) r[12], (Double) r[13], (Integer) r[14],
						(String) r[15], (Integer) r[16]);
				return loc;
			}).collect(Collectors.toList());
		}
		return localizaciones;
	}

}
