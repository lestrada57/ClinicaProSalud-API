package idat.edu.prosalud.service;

import idat.edu.prosalud.dto.PacienteDTO;
import idat.edu.prosalud.entity.Paciente;
import idat.edu.prosalud.mapper.PacienteMapper;
import idat.edu.prosalud.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService implements CrudSevice<PacienteDTO> {

    private final PacienteRepository repository;
    private final PacienteMapper mapper;

    @Override
    public PacienteDTO finById(Long id) {
        Paciente entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con id: " + id));
        return mapper.toDTO(entity);
    }

    @Override
    public List<PacienteDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public PacienteDTO create(PacienteDTO dto) {
        Paciente entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public PacienteDTO update(Long id, PacienteDTO dto) {
        Paciente entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con id: " + id));
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new RuntimeException("Paciente no encontrado con id: " + id);
        repository.deleteById(id);
    }
}
