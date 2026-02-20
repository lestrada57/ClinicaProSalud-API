package idat.edu.prosalud.service;

import idat.edu.prosalud.dto.PacienteDTO;
import idat.edu.prosalud.entity.Paciente;
import idat.edu.prosalud.mapper.PacienteMapper;
import idat.edu.prosalud.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService implements CrudSevice<PacienteDTO> {

    private final PacienteRepository repository;
    private final PacienteMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public PacienteDTO finById(Long id) {
        Paciente entity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Paciente no encontrado con id: " + id));
        return mapper.toDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PacienteDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    @Transactional
    public PacienteDTO create(PacienteDTO dto) {
        if (repository.existsByDni(dto.getDni())) {
            throw new RuntimeException("Ya existe un paciente con DNI: " + dto.getDni());
        }
        Paciente entity = mapper.toEntity(dto);
        Paciente saved = repository.save(entity);
        return mapper.toDTO(saved);
    }

    @Override
    @Transactional
    public PacienteDTO update(Long id, PacienteDTO dto) {
        Paciente entity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Paciente no encontrado con id: " + id));
        mapper.updateEntityFromDTO(dto, entity);
        Paciente updated = repository.save(entity);
        return mapper.toDTO(updated);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Paciente no encontrado con id: " + id);
        }
        repository.deleteById(id);
    }
}
