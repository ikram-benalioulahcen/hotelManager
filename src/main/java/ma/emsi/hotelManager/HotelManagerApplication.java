package ma.emsi.hotelManager;

import ma.emsi.hotelManager.model.Chambre;
import ma.emsi.hotelManager.model.Client;
import ma.emsi.hotelManager.model.Employe;
import ma.emsi.hotelManager.model.Facture;
import ma.emsi.hotelManager.repository.ChambreRepository;
import ma.emsi.hotelManager.repository.ClientRepository;
import ma.emsi.hotelManager.repository.EmployeRepository;
import ma.emsi.hotelManager.repository.FactureRepository;
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

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class HotelManagerApplication {


	@Bean
	CommandLineRunner runEmploye(EmployeRepository employeRepository) {
		return args -> {
			employeRepository.save(new Employe(null,"Ahmed","Bachar",1,"AA159","Rabat","ahmed@gmail.com", LocalDate.of(1998, 11, 10) ));
			employeRepository.save(new Employe(null,"Rania","Brahmi",1,"RA167","Casablanca","rania@gmail.com", LocalDate.of(1995, 5, 2) ));
			employeRepository.save(new Employe(null,"Mohammed","Arharbi",1,"ABC85","Rabat","mohammed@gmail.com", LocalDate.of(1999, 4, 18) ));
			employeRepository.save(new Employe(null,"Mehdi","moataz",1,"AB954","Rabat","mehhdi@gmail.com", LocalDate.of(2000, 9, 25) ));

		};
	}

	@Bean
	CommandLineRunner runFacture(FactureRepository factureRepository) {
		return args -> {
			factureRepository.save(new Facture(null,1500.0,0.0));
			factureRepository.save(new Facture(null,2000.0,0.0));
			factureRepository.save(new Facture(null,3500.0,3000.0));
			factureRepository.save(new Facture(null,2000.0,1000.0));
		};
	}

	@Bean
	CommandLineRunner runClient(ClientRepository clientRepository) {
		return args -> {
			clientRepository.save(new Client(null,"Adrian","Smith","Francais",false,"123456789","adrian@test.com",false,LocalDate.of(1995,12,5)));
			clientRepository.save(new Client(null,"Nina","Hemsworth","Americain",true,"123456789","nina@test.com",true,LocalDate.of(1990,12,5)));
		};
	}
	@Bean
	CommandLineRunner runChambre(ChambreRepository chambreRepository) {
		return args -> {
			chambreRepository.save(new Chambre( null,15,2,true,"123456", 200L));
			chambreRepository.save(new Chambre( null,20,3,true,"123456",600L));
			chambreRepository.save(new Chambre( null,10,2,false,"123456",500L));
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
