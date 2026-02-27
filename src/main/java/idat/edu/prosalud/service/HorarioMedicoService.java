package idat.edu.prosalud.service;

import idat.edu.prosalud.dto.HorarioMedicoDTO;
import idat.edu.prosalud.entity.HorarioMedico;
import idat.edu.prosalud.mapper.HorarioMedicoMapper;
import idat.edu.prosalud.repository.HorarioMedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HorarioMedicoService implements CrudSevice<HorarioMedicoDTO> {

    private final HorarioMedicoRepository repository;
    private final HorarioMedicoMapper mapper;

    @Override
    public HorarioMedicoDTO finById(Long id) {
        HorarioMedico entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horario no encontrado con id: " + id));
        return mapper.toDTO(entity);
    }

    @Override
    public List<HorarioMedicoDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public HorarioMedicoDTO create(HorarioMedicoDTO dto) {
        HorarioMedico entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public HorarioMedicoDTO update(Long id, HorarioMedicoDTO dto) {
        HorarioMedico entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horario no encontrado con id: " + id));
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new RuntimeException("Horario no encontrado con id: " + id);
        repository.deleteById(id);
    }
}

