package idat.edu.prosalud.mapper;

import idat.edu.prosalud.dto.request.PacienteRequestDTO;
import idat.edu.prosalud.dto.response.PacienteResponseDTO;
import idat.edu.prosalud.entity.Paciente;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

    @Mapping(target = "usuario", ignore = true)
    Paciente toEntity(PacienteRequestDTO dto);

    @Mapping(source = "usuario.id",       target = "usuarioId")
    @Mapping(source = "usuario.username", target = "usuarioUsername")
    PacienteResponseDTO toResponseDTO(Paciente entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "usuario", ignore = true)
    void updateEntityFromDTO(PacienteRequestDTO dto, @MappingTarget Paciente entity);
}

