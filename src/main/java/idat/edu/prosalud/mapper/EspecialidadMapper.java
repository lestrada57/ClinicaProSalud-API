package idat.edu.prosalud.mapper;

import idat.edu.prosalud.dto.EspecialidadDTO;
import idat.edu.prosalud.entity.Especialidad;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EspecialidadMapper {

    Especialidad toEntity(EspecialidadDTO dto);

    EspecialidadDTO toDTO(Especialidad entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(EspecialidadDTO dto, @MappingTarget Especialidad entity);
}
