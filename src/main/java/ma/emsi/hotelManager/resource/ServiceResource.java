package ma.emsi.hotelManager.resource;

import lombok.RequiredArgsConstructor;
import ma.emsi.hotelManager.model.Service;
import ma.emsi.hotelManager.model.Response;
import ma.emsi.hotelManager.service.implementation.ServiceServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/service")
@RequiredArgsConstructor
public class ServiceResource  {
    private final ServiceServiceImpl serviceService;

    @GetMapping("/list")
    public ResponseEntity<Response> getservices() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("service", serviceService.list(30)))
                        .message("services retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


    @PostMapping("/save")
    public ResponseEntity<Response> saveservice(@RequestBody @Valid Service service) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("service", serviceService.create(service)))
                        .message("service created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getservice(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("service", serviceService.get(id)))
                        .message("service retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Response> deleteservice(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", serviceService.delete(id)))
                        .message("service deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
