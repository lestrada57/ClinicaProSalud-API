package idat.edu.prosalud.controller;

import idat.edu.prosalud.dto.EspecialidadDTO;
import idat.edu.prosalud.service.EspecialidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
@RequiredArgsConstructor
public class EspecialidadController {

    private final EspecialidadService service;

    @GetMapping
    public ResponseEntity<List<EspecialidadDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.finById(id));
    }

    @PostMapping
    public ResponseEntity<EspecialidadDTO> create(@RequestBody EspecialidadDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspecialidadDTO> update(@PathVariable Long id, @RequestBody EspecialidadDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

