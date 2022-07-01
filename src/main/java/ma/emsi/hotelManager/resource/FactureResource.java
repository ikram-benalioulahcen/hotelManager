package ma.emsi.hotelManager.resource;

import lombok.RequiredArgsConstructor;
import ma.emsi.hotelManager.model.Facture;
import ma.emsi.hotelManager.model.Response;
import ma.emsi.hotelManager.service.implementation.FactureServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/facture")
@RequiredArgsConstructor
public class FactureResource {

    private final FactureServiceImpl factureService;

    @GetMapping("/list")
    public ResponseEntity<Response> getFaacture() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("facture", factureService.list(30)))
                        .message("Factures retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


    @PostMapping("/save")
    public ResponseEntity<Response> saveFacture(@RequestBody @Valid Facture facture) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("facture", factureService.create(facture)))
                        .message("Facture created")
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
                        .data(of("facture", factureService.get(id)))
                        .message("Facture retrieved")
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
                        .data(of("facture", factureService.delete(id)))
                        .message("Facture deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
