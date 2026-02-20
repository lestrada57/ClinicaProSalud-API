package idat.edu.prosalud.mapper;

import idat.edu.prosalud.dto.request.TratamientoRequestDTO;
import idat.edu.prosalud.dto.response.TratamientoResponseDTO;
import idat.edu.prosalud.entity.Tratamiento;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TratamientoMapper {

    @Mapping(target = "consulta", ignore = true)
    Tratamiento toEntity(TratamientoRequestDTO dto);

    @Mapping(source = "consulta.id", target = "consultaId")
    TratamientoResponseDTO toResponseDTO(Tratamiento entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "consulta", ignore = true)
    void updateEntityFromDTO(TratamientoRequestDTO dto, @MappingTarget Tratamiento entity);
}

