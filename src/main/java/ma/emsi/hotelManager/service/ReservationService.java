package ma.emsi.hotelManager.service;

import ma.emsi.hotelManager.model.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation create(Reservation reservation);
    List<Reservation> list(int limit);
    Reservation get(Long id);
    Reservation update(Reservation reservation);
    Boolean delete(Long id);
}
