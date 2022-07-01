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
	CommandLineRunner runFedelite(FedeliteRepository fedeliteRepository) {
		return args -> {
			fedeliteRepository.save(new Fedelite(null));
			fedeliteRepository.save(new Fedelite(null));
		};
	}

//autentification
	@Bean
	CommandLineRunner runAuthentification(AuthentificationRepository authentificationRepository) {
		return args -> {
			authentificationRepository.save(new Authentification(null,"Nour Belyazidi","belyazidi1"));
			authentificationRepository.save(new Authentification(null,"admin","admin"));
			authentificationRepository.save(new Authentification(null,"user","user"));
			authentificationRepository.save(new Authentification(null,"admin1","admin1"));
		};
	}

	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	//reservation
	@Bean
	CommandLineRunner runReservation(ReservationRepository reservationRepository) {
		return args -> {
			reservationRepository.save(new Reservation(null,2,1,"reservation-name",formatter.parse("10-06-2022" )));
			reservationRepository.save(new Reservation(null,5,1,"reservation-name2",formatter.parse("20-07-2022" )));
			reservationRepository.save(new Reservation(null,3,1,"reservation-name3",formatter.parse("15-05-2022" )));
			reservationRepository.save(new Reservation(null,3,1,"reservation-name4",formatter.parse("05-05-2022" )));
			reservationRepository.save(new Reservation(null,3,1,"reservation-name5",formatter.parse("07-05-2022" )));
			reservationRepository.save(new Reservation(null,3,1,"reservation-name6",formatter.parse("23-05-2022" )));
			reservationRepository.save(new Reservation(null,3,1,"reservation-name7",formatter.parse("14-05-2022" )));

		};
	}


	//service
	@Bean
	CommandLineRunner runService(ServiceRepository serviceRepository) {
		return args -> {
			serviceRepository.save(new Service(null,"spa","bla bla",400.0));
			serviceRepository.save(new Service(null,"7enna","bla bla",200.0));
			serviceRepository.save(new Service(null,"soiriat","bla bla",1000.0));
			serviceRepository.save(new Service(null,"ftour beldi","bla bla",100.0));
			serviceRepository.save(new Service(null,"tssbin","bla bla",500.0));
			serviceRepository.save(new Service(null,"internet","bla bla",300.0));
		};
	}

	//type
	@Bean
	CommandLineRunner runType(TypeRepository typeRepository) {
		return args -> {
			typeRepository.save(new Type(null,"king","kbir",4,6));
			typeRepository.save(new Type(null,"double","kbir bzzzzf",4,10));
			typeRepository.save(new Type(null,"single","sgir",4,10));
			typeRepository.save(new Type(null,"jana7","kbir bzzzzf",6,10));
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
