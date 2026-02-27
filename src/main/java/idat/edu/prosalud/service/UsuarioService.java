package idat.edu.prosalud.service;

import idat.edu.prosalud.dto.UsuarioDTO;
import idat.edu.prosalud.entity.Usuario;
import idat.edu.prosalud.mapper.UsuarioMapper;
import idat.edu.prosalud.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService implements CrudSevice<UsuarioDTO> {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    @Override
    public UsuarioDTO finById(Long id) {
        Usuario entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
        return mapper.toDTO(entity);
    }

    @Override
    public List<UsuarioDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public UsuarioDTO create(UsuarioDTO dto) {
        Usuario entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public UsuarioDTO update(Long id, UsuarioDTO dto) {
        Usuario entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new RuntimeException("Usuario no encontrado con id: " + id);
        repository.deleteById(id);
    }
}
