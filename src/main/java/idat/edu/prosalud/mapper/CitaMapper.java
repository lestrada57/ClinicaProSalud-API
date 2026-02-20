package idat.edu.prosalud.mapper;

import idat.edu.prosalud.dto.CitaDTO;
import idat.edu.prosalud.entity.Cita;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CitaMapper {

    @Mapping(target = "paciente",              ignore = true)
    @Mapping(target = "medico",                ignore = true)
    @Mapping(target = "recepcionistaRegistro", ignore = true)
    @Mapping(target = "recepcionistaAtencion", ignore = true)
    Cita toEntity(CitaDTO dto);

    @Mapping(source = "paciente.id",              target = "pacienteId")
    @Mapping(source = "medico.id",                target = "medicoId")
    @Mapping(source = "recepcionistaRegistro.id", target = "recepcionistaRegistroId")
    @Mapping(source = "recepcionistaAtencion.id", target = "recepcionistaAtencionId")
    CitaDTO toDTO(Cita entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "paciente",              ignore = true)
    @Mapping(target = "medico",                ignore = true)
    @Mapping(target = "recepcionistaRegistro", ignore = true)
    @Mapping(target = "recepcionistaAtencion", ignore = true)
    void updateEntityFromDTO(CitaDTO dto, @MappingTarget Cita entity);
}
