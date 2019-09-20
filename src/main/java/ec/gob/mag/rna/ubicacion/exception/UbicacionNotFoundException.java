package ec.gob.mag.rna.ubicacion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UbicacionNotFoundException extends RuntimeException {
	public UbicacionNotFoundException(String message) {
		super(message);
	}
}
