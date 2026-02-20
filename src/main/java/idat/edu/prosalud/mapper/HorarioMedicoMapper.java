package idat.edu.prosalud.mapper;

import idat.edu.prosalud.dto.HorarioMedicoDTO;
import idat.edu.prosalud.entity.HorarioMedico;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface HorarioMedicoMapper {

    @Mapping(target = "medico", ignore = true)
    HorarioMedico toEntity(HorarioMedicoDTO dto);

    @Mapping(source = "medico.id", target = "medicoId")
    HorarioMedicoDTO toDTO(HorarioMedico entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "medico", ignore = true)
    void updateEntityFromDTO(HorarioMedicoDTO dto, @MappingTarget HorarioMedico entity);
}
