package ma.emsi.hotelManager.repository;

import ma.emsi.hotelManager.model.Employe;
import ma.emsi.hotelManager.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
