package ec.gob.mag.rna.ubicacion.config;

import org.springframework.stereotype.Component;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;

@Component
public class HealthCheck implements HealthCheckHandler {

	private int counter = -1;

	@Override
	public InstanceStatus getStatus(InstanceStatus currentStatus) {
		counter++;

		switch (counter) {
		case 0:
			return InstanceStatus.OUT_OF_SERVICE;
		case 1:
			return InstanceStatus.DOWN;
		case 2:
			return InstanceStatus.STARTING;
		case 3:
			return InstanceStatus.UNKNOWN;
		default:
			return InstanceStatus.UP;
		}
	}

}
