package ec.gob.mag.rna.ubicacion;


import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;


@Component
public class Mensajes {
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
           ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
           messageSource.setBasename("messages_es");
           return messageSource;
	}

}