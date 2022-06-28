package ma.emsi.hotelManager.repository;

import ma.emsi.hotelManager.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    Employe findByName();


    public Employe findById(int id);

    public List<Employe> findAll();


}