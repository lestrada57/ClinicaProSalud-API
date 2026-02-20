package idat.edu.prosalud.mapper;

import idat.edu.prosalud.dto.request.CitaRequestDTO;
import idat.edu.prosalud.dto.response.CitaResponseDTO;
import idat.edu.prosalud.entity.Cita;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CitaMapper {

    @Mapping(target = "paciente",               ignore = true)
    @Mapping(target = "medico",                 ignore = true)
    @Mapping(target = "recepcionistaRegistro",  ignore = true)
    @Mapping(target = "recepcionistaAtencion",  ignore = true)
    Cita toEntity(CitaRequestDTO dto);

    @Mapping(source = "paciente.id",                        target = "pacienteId")
    @Mapping(source = "paciente.nombres",                   target = "pacienteNombres")
    @Mapping(source = "paciente.apellidos",                 target = "pacienteApellidos")
    @Mapping(source = "paciente.dni",                       target = "pacienteDni")
    @Mapping(source = "medico.id",                          target = "medicoId")
    @Mapping(source = "medico.nombres",                     target = "medicoNombres")
    @Mapping(source = "medico.apellidos",                   target = "medicoApellidos")
    @Mapping(source = "medico.especialidad.nombre",         target = "especialidadNombre")
    @Mapping(source = "recepcionistaRegistro.id",           target = "recepcionistaRegistroId")
    @Mapping(source = "recepcionistaRegistro.nombres",      target = "recepcionistaRegistroNombres")
    @Mapping(source = "recepcionistaAtencion.id",           target = "recepcionistaAtencionId")
    @Mapping(source = "recepcionistaAtencion.nombres",      target = "recepcionistaAtencionNombres")
    CitaResponseDTO toResponseDTO(Cita entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "paciente",              ignore = true)
    @Mapping(target = "medico",                ignore = true)
    @Mapping(target = "recepcionistaRegistro", ignore = true)
    @Mapping(target = "recepcionistaAtencion", ignore = true)
    void updateEntityFromDTO(CitaRequestDTO dto, @MappingTarget Cita entity);
}

