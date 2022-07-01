package ma.emsi.hotelManager.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.hotelManager.model.Reservation;
import ma.emsi.hotelManager.repository.ReservationRepository;
import ma.emsi.hotelManager.service.ReservationService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    @Override
    public Reservation create(Reservation reservation) {
        log.info("Saving Reservation");
        return reservationRepository.save(reservation);
    }


    @Override
    public List<Reservation> list(int limit) {
        log.info("Showing Reservations");
        return reservationRepository.findAll(PageRequest.of( 0, limit)).toList();
    }

    @Override
    public Reservation get(Long id) {
        log.info("getting reservation of id : "+ id);
        return reservationRepository.findById(id).get();
    }

    @Override
    public Reservation update(Reservation reservation) {
        log.info("Updating Reservation");
        return reservationRepository.save(reservation);
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting Reservation of id :{}", id);
        reservationRepository.deleteById(id);
        return TRUE;
    }
}
