package ma.emsi.hotelManager.repository;

import ma.emsi.hotelManager.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    //List<Employe> findAll(String name);
    //Employe findByName(String name);
}