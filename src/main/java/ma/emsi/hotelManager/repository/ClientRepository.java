package ma.emsi.hotelManager.repository;

import ma.emsi.hotelManager.model.Client;
import ma.emsi.hotelManager.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
