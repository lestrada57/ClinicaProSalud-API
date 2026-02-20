package idat.edu.prosalud.mapper;

import idat.edu.prosalud.dto.request.MedicoRequestDTO;
import idat.edu.prosalud.dto.response.MedicoResponseDTO;
import idat.edu.prosalud.entity.Medico;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface MedicoMapper {

    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "especialidad", ignore = true)
    Medico toEntity(MedicoRequestDTO dto);

    @Mapping(source = "usuario.id",         target = "usuarioId")
    @Mapping(source = "usuario.username",   target = "usuarioUsername")
    @Mapping(source = "especialidad.id",    target = "especialidadId")
    @Mapping(source = "especialidad.nombre",target = "especialidadNombre")
    MedicoResponseDTO toResponseDTO(Medico entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "especialidad", ignore = true)
    void updateEntityFromDTO(MedicoRequestDTO dto, @MappingTarget Medico entity);
}

