package ma.emsi.hotelManager.resource;

import lombok.RequiredArgsConstructor;
import ma.emsi.hotelManager.model.Facture;
import ma.emsi.hotelManager.model.Fedelite;
import ma.emsi.hotelManager.model.Response;
import ma.emsi.hotelManager.service.implementation.FactureServiceImpl;
import ma.emsi.hotelManager.service.implementation.FedeliteServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/fedelite")
@RequiredArgsConstructor
public class FedeliteResource {

    private final FedeliteServiceImpl fedeliteService;

    @GetMapping("/list")
    public ResponseEntity<Response> getFedelites() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("fedelites", fedeliteService.list(30)))
                        .message("Fedelites retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


    @PostMapping("/save")
    public ResponseEntity<Response> saveFedelite(@RequestBody @Valid Fedelite fedelite) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("fedelite", fedeliteService.create(fedelite)))
                        .message("Fedelite created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getFacture(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("fedelite", fedeliteService.get(id)))
                        .message("Fedelite retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Response> deleteFacture(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", fedeliteService.delete(id)))
                        .message("Fedelite deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
