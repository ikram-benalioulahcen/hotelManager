package ma.emsi.hotelManager;

import ma.emsi.hotelManager.model.*;
import ma.emsi.hotelManager.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class HotelManagerApplication {



//	//service
//	@Bean
//	CommandLineRunner runService(ServiceRepository serviceRepository) {
//		return args -> {
//			serviceRepository.save(new Service(null,"spa","bla bla",400.0));
//			serviceRepository.save(new Service(null,"7enna","bla bla",200.0));
//			serviceRepository.save(new Service(null,"soiriat","bla bla",1000.0));
//			serviceRepository.save(new Service(null,"ftour beldi","bla bla",100.0));
//			serviceRepository.save(new Service(null,"tssbin","bla bla",500.0));
//			serviceRepository.save(new Service(null,"internet","bla bla",300.0));
//		};
//	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}


	public static void main(String[] args) {

		SpringApplication.run(HotelManagerApplication.class, args);
	}

//	@GetMapping
//	public List<String> hello(){
//		return List.of("Hello","World");
//	}

}
