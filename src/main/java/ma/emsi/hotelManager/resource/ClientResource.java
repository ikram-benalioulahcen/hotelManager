package ma.emsi.hotelManager.resource;

import lombok.RequiredArgsConstructor;
import ma.emsi.hotelManager.model.Client;
import ma.emsi.hotelManager.model.Employe;
import ma.emsi.hotelManager.model.Response;
import ma.emsi.hotelManager.service.implementation.ClientServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientResource {

    private final ClientServiceImpl clientService;

    @GetMapping("/list")
    public ResponseEntity<Response> getClients() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("clients", clientService.list(30)))
                        .message("clients retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


    @PostMapping("/save")
    public ResponseEntity<Response> saveClient(@RequestBody @Valid Client client) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("client", clientService.create(client)))
                        .message("client created")
                        .status(CREATED)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getClient(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("client", clientService.get(id)))
                        .message("client found")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateClient(@PathVariable("id") Long id, @RequestBody @Valid Client client) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("client", clientService.update(id,client)))
                        .message("client updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Response> deleteClient(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", clientService.delete(id)))
                        .message("client deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
