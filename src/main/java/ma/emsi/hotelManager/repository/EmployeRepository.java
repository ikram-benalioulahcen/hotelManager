package ma.emsi.hotelManager.repository;

import ma.emsi.hotelManager.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    //Employe findByName()
}
