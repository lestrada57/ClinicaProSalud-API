package idat.edu.prosalud.service;

import idat.edu.prosalud.dto.PacienteDTO;
import idat.edu.prosalud.entity.Paciente;
import idat.edu.prosalud.mapper.PacienteMapper;
import idat.edu.prosalud.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService implements CrudSevice<PacienteDTO> {

    PacienteRepository repository;
    PacienteMapper mapper;

    @Override
    public PacienteDTO finById(Long id) {

        Paciente entity = repository.findById(id).orElseThrow(
                ()->new RuntimeException("Paciente no encontrado"));

        return mapper.toDTO(entity);
    }

    @Override
    public List<PacienteDTO> findAll() {
        return List.of();
    }

    @Override
    public PacienteDTO create(PacienteDTO entity) {
        return null;
    }

    @Override
    public PacienteDTO update(Long id, PacienteDTO entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
