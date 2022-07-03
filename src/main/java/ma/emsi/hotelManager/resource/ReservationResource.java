package ma.emsi.hotelManager.resource;

import lombok.RequiredArgsConstructor;
import ma.emsi.hotelManager.model.Reservation;
import ma.emsi.hotelManager.model.Response;
import ma.emsi.hotelManager.service.implementation.ReservationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationResource  {
    private final ReservationServiceImpl reservationService;

    @GetMapping("/list")
    public ResponseEntity<Response> getreservations() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("reservations", reservationService.list(30)))
                        .message("reservations retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


    @PostMapping("/save")
    public ResponseEntity<Response> savereservation(@RequestBody @Valid Reservation reservation) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("reservation", reservationService.create(reservation)))
                        .message("reservation created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getreservation(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("reservation", reservationService.get(id)))
                        .message("reservation retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Response> deletereservation(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", reservationService.delete(id)))
                        .message("reservation deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}