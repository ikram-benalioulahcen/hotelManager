package ma.emsi.hotelManager.resource;

import lombok.RequiredArgsConstructor;
import ma.emsi.hotelManager.model.Client;
import ma.emsi.hotelManager.model.Response;
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
                        .data(of("client", clientService.list(30)))
                        .message("Clients retrieved")
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
                        .message("Client created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getClient(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("client", clientService.get(id)))
                        .message("client retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteClient(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", clientService.delete(id)))
                        .message("Client deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
