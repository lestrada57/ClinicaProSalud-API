package idat.edu.prosalud.service;

import idat.edu.prosalud.dto.ConsultaDTO;
import idat.edu.prosalud.entity.Consulta;
import idat.edu.prosalud.mapper.ConsultaMapper;
import idat.edu.prosalud.repository.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService implements CrudSevice<ConsultaDTO> {

    private final ConsultaRepository repository;
    private final ConsultaMapper mapper;

    @Override
    public ConsultaDTO finById(Long id) {
        Consulta entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta no encontrada con id: " + id));
        return mapper.toDTO(entity);
    }

    @Override
    public List<ConsultaDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public ConsultaDTO create(ConsultaDTO dto) {
        Consulta entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public ConsultaDTO update(Long id, ConsultaDTO dto) {
        Consulta entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta no encontrada con id: " + id));
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new RuntimeException("Consulta no encontrada con id: " + id);
        repository.deleteById(id);
    }
}

