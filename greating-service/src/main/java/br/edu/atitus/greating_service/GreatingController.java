package br.edu.atitus.greating_service;
import br.edu.atitus.greating_service.config.GreatingConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greating-service")
public class GreatingController {

//    @Value("${greating-service.greating}")
//    private String greating;
//    @Value("${greating-service.greating}")
//    private String nameDefault;

   private final GreatingConfig greatingConfig;

    public GreatingController(GreatingConfig greatingConfig) {
        super();
        this.greatingConfig = greatingConfig;
    }

    @GetMapping({"","/","/{namePath}"})
    public ResponseEntity<String> getGreating(@PathVariable(required = false) String namePath,
                                              @RequestParam(required = false) String name) {
        if (name == null)
            name = namePath != null ? namePath : greatingConfig.getDefaultName();

        String returnText = String.format("%s %s!", greatingConfig.getGreating(), name);
        return ResponseEntity.ok(returnText);
    }
}