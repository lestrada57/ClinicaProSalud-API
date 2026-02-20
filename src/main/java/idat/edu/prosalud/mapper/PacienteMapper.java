package idat.edu.prosalud.mapper;

import idat.edu.prosalud.dto.PacienteDTO;
import idat.edu.prosalud.entity.Paciente;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

    @Mapping(target = "usuario", ignore = true)
    Paciente toEntity(PacienteDTO dto);

    @Mapping(source = "usuario.id", target = "usuarioId")
    PacienteDTO toDTO(Paciente entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "usuario", ignore = true)
    void updateEntityFromDTO(PacienteDTO dto, @MappingTarget Paciente entity);
}
