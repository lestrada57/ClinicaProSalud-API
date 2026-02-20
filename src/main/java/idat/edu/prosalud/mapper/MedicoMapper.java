package idat.edu.prosalud.mapper;

import idat.edu.prosalud.dto.MedicoDTO;
import idat.edu.prosalud.entity.Medico;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface MedicoMapper {

    @Mapping(target = "usuario",      ignore = true)
    @Mapping(target = "especialidad", ignore = true)
    Medico toEntity(MedicoDTO dto);

    @Mapping(source = "usuario.id",      target = "usuarioId")
    @Mapping(source = "especialidad.id", target = "especialidadId")
    MedicoDTO toDTO(Medico entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "usuario",      ignore = true)
    @Mapping(target = "especialidad", ignore = true)
    void updateEntityFromDTO(MedicoDTO dto, @MappingTarget Medico entity);
}
