package ma.emsi.hotelManager.resource;

import lombok.RequiredArgsConstructor;
import ma.emsi.hotelManager.model.Authentification;
import ma.emsi.hotelManager.model.Response;
import ma.emsi.hotelManager.service.implementation.AuthentificationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/authentification")
@RequiredArgsConstructor
public class AuthentificationResource  {
    private final AuthentificationServiceImpl authentificationService;

    @GetMapping("/list")
    public ResponseEntity<Response> getauthentifications() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("authentifications", authentificationService.list(30)))
                        .message("authentifications retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


    @PostMapping("/save")
    public ResponseEntity<Response> saveauthentification(@RequestBody @Valid Authentification authentification) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("authentification", authentificationService.create(authentification)))
                        .message("authentification created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getauthentificationUsername(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("authentification", authentificationService.get(id)))
                        .message("authentification retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/getUser/{username}")
    public ResponseEntity<Response> getauthentification(@PathVariable("username") String username) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("authentification", authentificationService.getByUsername(username)))
                        .message("authentification retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Response> deleteauthentification(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", authentificationService.delete(id)))
                        .message("authentification deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
