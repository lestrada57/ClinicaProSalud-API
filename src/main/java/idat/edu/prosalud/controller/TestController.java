package idat.edu.prosalud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/saludo")
    public ResponseEntity<Map<String, String>> saludo(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(Map.of(
                "mensaje", "Hola, " + userDetails.getUsername() + " Tu JWT es válido",
                "rol", userDetails.getAuthorities().iterator().next().getAuthority()
        ));
    }
}

