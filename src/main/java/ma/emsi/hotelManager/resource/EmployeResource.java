package ma.emsi.hotelManager.resource;


import lombok.RequiredArgsConstructor;
import ma.emsi.hotelManager.model.Employe;
import ma.emsi.hotelManager.model.Response;
import ma.emsi.hotelManager.service.implementation.EmployeServiceImpl;
import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import javax.validation.Valid;
//        import java.io.IOException;
//        import java.nio.file.Files;
//        import java.nio.file.Paths;
        import java.util.concurrent.TimeUnit;
        import static java.time.LocalDateTime.now;
        import static java.util.Map.of;
        import static org.springframework.http.HttpStatus.CREATED;
        import static org.springframework.http.HttpStatus.OK;

 // employe controller
@RestController
@RequestMapping("/employe")
@RequiredArgsConstructor
public class EmployeResource  {
    private final EmployeServiceImpl employeService;

    @GetMapping("/list")
    public ResponseEntity<Response> getEmployes() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("employe", employeService.list(30)))
                        .message("Employes retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


    @PostMapping("/save")
    public ResponseEntity<Response> saveEmploye(@RequestBody @Valid Employe server) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("server", employeService.create(server)))
                        .message("Server created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getEmploye(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("employe", employeService.get(id)))
                        .message("Employe retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteEmploye(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", employeService.delete(id)))
                        .message("Employe deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

//    @GetMapping(path = "/image/{fileName}", produces = IMAGE_PNG_VALUE)
//    public byte[] getServerImage(@PathVariable("fileName") String fileName) throws IOException {
//        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/Downloads/images/" + fileName));
//    }
}
