package ma.emsi.hotelManager.resource;

import lombok.RequiredArgsConstructor;
import ma.emsi.hotelManager.model.Chambre;
import ma.emsi.hotelManager.model.Client;
import ma.emsi.hotelManager.model.Response;
import ma.emsi.hotelManager.service.implementation.ChambreServiceImpl;
import ma.emsi.hotelManager.service.implementation.ClientServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/chambre")
@RequiredArgsConstructor
public class ChambreResource {
    private final ChambreServiceImpl chambreService;

    @GetMapping("/list")
    public ResponseEntity<Response> getChambres() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("chambres", chambreService.list(30)))
                        .message("Chambres retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


    @PostMapping("/save")
    public ResponseEntity<Response> saveChambre(@RequestBody @Valid Chambre chambre) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("chambre", chambreService.create(chambre)))
                        .message("Chambre created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getChambre(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("chambre", chambreService.get(id)))
                        .message("chambre retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Response> deleteChambre(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", chambreService.delete(id)))
                        .message("Chambre deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
