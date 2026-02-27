package idat.edu.prosalud.controller;

import idat.edu.prosalud.dto.RecepcionistaDTO;
import idat.edu.prosalud.service.RecepcionistaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recepcionistas")
@RequiredArgsConstructor
public class RecepcionistaController {

    private final RecepcionistaService service;

    @GetMapping
    public ResponseEntity<List<RecepcionistaDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecepcionistaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.finById(id));
    }

    @PostMapping
    public ResponseEntity<RecepcionistaDTO> create(@RequestBody RecepcionistaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecepcionistaDTO> update(@PathVariable Long id, @RequestBody RecepcionistaDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

