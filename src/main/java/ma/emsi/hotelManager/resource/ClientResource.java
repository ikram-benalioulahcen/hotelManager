package ma.emsi.hotelManager.resource;

import lombok.RequiredArgsConstructor;
import ma.emsi.hotelManager.model.Client;
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
    public ResponseEntity<List<Client>> getClients() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return ResponseEntity.ok(
                clientService.list(30));


    }


    @PostMapping("/save")
    public ResponseEntity<Client> saveClient(@RequestBody @Valid Client client) {
        return ResponseEntity.ok(
                clientService.create(client));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                clientService.get(id)
        );
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteClient(@PathVariable("id") Long id) {
        return ResponseEntity.ok(clientService.delete(id));
    }
}
