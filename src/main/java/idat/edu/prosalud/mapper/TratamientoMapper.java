package idat.edu.prosalud.mapper;

import idat.edu.prosalud.dto.TratamientoDTO;
import idat.edu.prosalud.entity.Tratamiento;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TratamientoMapper {

    @Mapping(target = "consulta", ignore = true)
    Tratamiento toEntity(TratamientoDTO dto);

    @Mapping(source = "consulta.id", target = "consultaId")
    TratamientoDTO toDTO(Tratamiento entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "consulta", ignore = true)
    void updateEntityFromDTO(TratamientoDTO dto, @MappingTarget Tratamiento entity);
}
