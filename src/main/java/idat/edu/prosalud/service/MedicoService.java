package idat.edu.prosalud.service;

import idat.edu.prosalud.dto.MedicoDTO;
import idat.edu.prosalud.entity.Medico;
import idat.edu.prosalud.mapper.MedicoMapper;
import idat.edu.prosalud.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService implements CrudSevice<MedicoDTO> {

    private final MedicoRepository repository;
    private final MedicoMapper mapper;

    @Override
    public MedicoDTO finById(Long id) {
        Medico entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico no encontrado con id: " + id));
        return mapper.toDTO(entity);
    }

    @Override
    public List<MedicoDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public MedicoDTO create(MedicoDTO dto) {
        Medico entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public MedicoDTO update(Long id, MedicoDTO dto) {
        Medico entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico no encontrado con id: " + id));
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new RuntimeException("Médico no encontrado con id: " + id);
        repository.deleteById(id);
    }
}

