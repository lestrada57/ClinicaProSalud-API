package idat.edu.prosalud.service;

import idat.edu.prosalud.dto.RecepcionistaDTO;
import idat.edu.prosalud.entity.Recepcionista;
import idat.edu.prosalud.mapper.RecepcionistaMapper;
import idat.edu.prosalud.repository.RecepcionistaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecepcionistaService implements CrudSevice<RecepcionistaDTO> {

    private final RecepcionistaRepository repository;
    private final RecepcionistaMapper mapper;

    @Override
    public RecepcionistaDTO finById(Long id) {
        Recepcionista entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recepcionista no encontrado con id: " + id));
        return mapper.toDTO(entity);
    }

    @Override
    public List<RecepcionistaDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public RecepcionistaDTO create(RecepcionistaDTO dto) {
        Recepcionista entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public RecepcionistaDTO update(Long id, RecepcionistaDTO dto) {
        Recepcionista entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recepcionista no encontrado con id: " + id));
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new RuntimeException("Recepcionista no encontrado con id: " + id);
        repository.deleteById(id);
    }
}

