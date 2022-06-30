package ma.emsi.hotelManager;

import ma.emsi.hotelManager.model.Employe;
import ma.emsi.hotelManager.repository.EmployeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class HotelManagerApplication {


	@Bean
	CommandLineRunner run(EmployeRepository employeRepository) {
		return args -> {
			employeRepository.save(new Employe(null,"Ahmed","Bachar","AA159", LocalDate.of(1998, 11, 10) ));
			employeRepository.save(new Employe(null,"Rania","Brahmi","RA167", LocalDate.of(1995, 5, 2) ));
			employeRepository.save(new Employe(null,"Mohammed","Arharbi","ABC85", LocalDate.of(1999, 4, 18) ));
			employeRepository.save(new Employe(null,"Mehdi","moataz","AB954", LocalDate.of(2000, 9, 25) ));

		};
	}



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
		return new CorsFilter((CorsConfigurationSource) urlBasedCorsConfigurationSource);
	}
	public static void main(String[] args) {

		SpringApplication.run(HotelManagerApplication.class, args);
	}

//	@GetMapping
//	public List<String> hello(){
//		return List.of("Hello","World");
//	}

}
