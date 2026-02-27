package idat.edu.prosalud.controller;

import idat.edu.prosalud.dto.TratamientoDTO;
import idat.edu.prosalud.service.TratamientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tratamientos")
@RequiredArgsConstructor
public class TratamientoController {

    private final TratamientoService service;

    @GetMapping
    public ResponseEntity<List<TratamientoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TratamientoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.finById(id));
    }

    @PostMapping
    public ResponseEntity<TratamientoDTO> create(@RequestBody TratamientoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TratamientoDTO> update(@PathVariable Long id, @RequestBody TratamientoDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

