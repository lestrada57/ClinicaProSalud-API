package idat.edu.prosalud.service;

import idat.edu.prosalud.dto.TratamientoDTO;
import idat.edu.prosalud.entity.Tratamiento;
import idat.edu.prosalud.mapper.TratamientoMapper;
import idat.edu.prosalud.repository.TratamientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TratamientoService implements CrudSevice<TratamientoDTO> {

    private final TratamientoRepository repository;
    private final TratamientoMapper mapper;

    @Override
    public TratamientoDTO finById(Long id) {
        Tratamiento entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tratamiento no encontrado con id: " + id));
        return mapper.toDTO(entity);
    }

    @Override
    public List<TratamientoDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public TratamientoDTO create(TratamientoDTO dto) {
        Tratamiento entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public TratamientoDTO update(Long id, TratamientoDTO dto) {
        Tratamiento entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tratamiento no encontrado con id: " + id));
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new RuntimeException("Tratamiento no encontrado con id: " + id);
        repository.deleteById(id);
    }
}

