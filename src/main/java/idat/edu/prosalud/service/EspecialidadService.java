package idat.edu.prosalud.service;

import idat.edu.prosalud.dto.EspecialidadDTO;
import idat.edu.prosalud.entity.Especialidad;
import idat.edu.prosalud.mapper.EspecialidadMapper;
import idat.edu.prosalud.repository.EspecialidadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EspecialidadService implements CrudSevice<EspecialidadDTO> {

    private final EspecialidadRepository repository;
    private final EspecialidadMapper mapper;

    @Override
    public EspecialidadDTO finById(Long id) {
        Especialidad entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada con id: " + id));
        return mapper.toDTO(entity);
    }

    @Override
    public List<EspecialidadDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public EspecialidadDTO create(EspecialidadDTO dto) {
        Especialidad entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public EspecialidadDTO update(Long id, EspecialidadDTO dto) {
        Especialidad entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada con id: " + id));
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new RuntimeException("Especialidad no encontrada con id: " + id);
        repository.deleteById(id);
    }
}

