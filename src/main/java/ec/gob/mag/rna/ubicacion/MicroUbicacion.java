package ec.gob.mag.rna.ubicacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class MicroUbicacion extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MicroUbicacion.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	private static Class<MicroUbicacion> applicationClass = MicroUbicacion.class;

//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("*"));
//		configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
//		configuration.setAllowCredentials(true);
//		configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}
//
//	@Bean
//	public FilterRegistrationBean<CorsFilter> corsFilter() {
//		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(
//				new CorsFilter(corsConfigurationSource()));
//		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//		return bean;
//	}
}
