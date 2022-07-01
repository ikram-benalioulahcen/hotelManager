package ma.emsi.hotelManager.resource;

import lombok.RequiredArgsConstructor;
import ma.emsi.hotelManager.model.Type;
import ma.emsi.hotelManager.model.Response;
import ma.emsi.hotelManager.service.implementation.TypeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/type")
@RequiredArgsConstructor
public class TypeResource  {
    private final TypeServiceImpl typeService;

    @GetMapping("/list")
    public ResponseEntity<Response> gettypes() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("type", typeService.list(30)))
                        .message("types retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


    @PostMapping("/save")
    public ResponseEntity<Response> savetype(@RequestBody @Valid Type type) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("type", typeService.create(type)))
                        .message("type created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> gettype(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("type", typeService.get(id)))
                        .message("type retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Response> deletetype(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", typeService.delete(id)))
                        .message("type deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
