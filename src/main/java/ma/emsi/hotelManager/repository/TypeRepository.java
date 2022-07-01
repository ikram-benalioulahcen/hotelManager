package ma.emsi.hotelManager.repository;

import ma.emsi.hotelManager.model.Employe;
import ma.emsi.hotelManager.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
}
