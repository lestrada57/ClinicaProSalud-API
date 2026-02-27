package idat.edu.prosalud.controller;

import idat.edu.prosalud.dto.HorarioMedicoDTO;
import idat.edu.prosalud.service.HorarioMedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
@RequiredArgsConstructor
public class HorarioMedicoController {

    private final HorarioMedicoService service;

    @GetMapping
    public ResponseEntity<List<HorarioMedicoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioMedicoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.finById(id));
    }

    @PostMapping
    public ResponseEntity<HorarioMedicoDTO> create(@RequestBody HorarioMedicoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioMedicoDTO> update(@PathVariable Long id, @RequestBody HorarioMedicoDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

