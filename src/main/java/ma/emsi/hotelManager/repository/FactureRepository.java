package ma.emsi.hotelManager.repository;

import ma.emsi.hotelManager.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Long> {
}
