package ma.emsi.hotelManager.repository;

import ma.emsi.hotelManager.model.Authentification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthentificationRepository extends JpaRepository<Authentification, Long> {
    Authentification findByUsername(String username);
}
