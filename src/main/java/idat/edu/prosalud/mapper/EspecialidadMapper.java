package idat.edu.prosalud.mapper;

import idat.edu.prosalud.dto.request.EspecialidadRequestDTO;
import idat.edu.prosalud.dto.response.EspecialidadResponseDTO;
import idat.edu.prosalud.entity.Especialidad;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EspecialidadMapper {

    Especialidad toEntity(EspecialidadRequestDTO dto);

    EspecialidadResponseDTO toResponseDTO(Especialidad entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(EspecialidadRequestDTO dto, @MappingTarget Especialidad entity);
}

