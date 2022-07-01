package ma.emsi.hotelManager.repository;

import ma.emsi.hotelManager.model.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}
