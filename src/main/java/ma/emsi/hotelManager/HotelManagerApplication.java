package ma.emsi.hotelManager;

import ma.emsi.hotelManager.model.Employe;
import ma.emsi.hotelManager.repository.EmployeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
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

	public static void main(String[] args) {

		SpringApplication.run(HotelManagerApplication.class, args);
	}

//	@GetMapping
//	public List<String> hello(){
//		return List.of("Hello","World");
//	}

}
