package ma.emsi.hotelManager.repository;

import ma.emsi.hotelManager.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
