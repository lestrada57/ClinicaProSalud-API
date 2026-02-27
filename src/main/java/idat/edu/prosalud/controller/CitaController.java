package idat.edu.prosalud.controller;

import idat.edu.prosalud.dto.CitaDTO;
import idat.edu.prosalud.service.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@RequiredArgsConstructor
public class CitaController {

    private final CitaService service;

    @GetMapping
    public ResponseEntity<List<CitaDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.finById(id));
    }

    @PostMapping
    public ResponseEntity<CitaDTO> create(@RequestBody CitaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaDTO> update(@PathVariable Long id, @RequestBody CitaDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

