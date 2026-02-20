package idat.edu.prosalud.mapper;

import idat.edu.prosalud.dto.request.HorarioMedicoRequestDTO;
import idat.edu.prosalud.dto.response.HorarioMedicoResponseDTO;
import idat.edu.prosalud.entity.HorarioMedico;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface HorarioMedicoMapper {

    @Mapping(target = "medico", ignore = true)
    HorarioMedico toEntity(HorarioMedicoRequestDTO dto);

    @Mapping(source = "medico.id",       target = "medicoId")
    @Mapping(source = "medico.nombres",  target = "medicoNombres")
    @Mapping(source = "medico.apellidos",target = "medicoApellidos")
    HorarioMedicoResponseDTO toResponseDTO(HorarioMedico entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "medico", ignore = true)
    void updateEntityFromDTO(HorarioMedicoRequestDTO dto, @MappingTarget HorarioMedico entity);
}

