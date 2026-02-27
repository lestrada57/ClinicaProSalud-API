package idat.edu.prosalud.service;

import idat.edu.prosalud.dto.CitaDTO;
import idat.edu.prosalud.entity.Cita;
import idat.edu.prosalud.mapper.CitaMapper;
import idat.edu.prosalud.repository.CitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaService implements CrudSevice<CitaDTO> {

    private final CitaRepository repository;
    private final CitaMapper mapper;

    @Override
    public CitaDTO finById(Long id) {
        Cita entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con id: " + id));
        return mapper.toDTO(entity);
    }

    @Override
    public List<CitaDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public CitaDTO create(CitaDTO dto) {
        Cita entity = mapper.toEntity(dto);
        if (entity.getEstado() == null) entity.setEstado("PROGRAMADA");
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public CitaDTO update(Long id, CitaDTO dto) {
        Cita entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con id: " + id));
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new RuntimeException("Cita no encontrada con id: " + id);
        repository.deleteById(id);
    }
}

