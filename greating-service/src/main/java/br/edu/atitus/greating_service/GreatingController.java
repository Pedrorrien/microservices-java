package br.edu.atitus.greating_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greating-service")
public class GreatingController {

    @Value("${greating-service.greating}")
    private String greating;

    @Value("${greating-service.greating}")
    private String nameDefault;

    @GetMapping({"","/","/{namePath}"})
    public ResponseEntity<String> getGreating(@PathVariable(required = false) String namePath,
                                              @RequestParam(required = false) String name) {
        if (name == null)
            name = namePath != null ? namePath : "Word";

        String returnText = String.format("%s %s!", greating, name);
        return ResponseEntity.ok(returnText);
    }

}
