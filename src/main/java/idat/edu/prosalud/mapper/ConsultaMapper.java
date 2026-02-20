package idat.edu.prosalud.mapper;

import idat.edu.prosalud.dto.request.ConsultaRequestDTO;
import idat.edu.prosalud.dto.response.ConsultaResponseDTO;
import idat.edu.prosalud.entity.Consulta;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {

    @Mapping(target = "cita",     ignore = true)
    @Mapping(target = "paciente", ignore = true)
    @Mapping(target = "medico",   ignore = true)
    Consulta toEntity(ConsultaRequestDTO dto);

    @Mapping(source = "cita.id",          target = "citaId")
    @Mapping(source = "paciente.id",      target = "pacienteId")
    @Mapping(source = "paciente.nombres", target = "pacienteNombres")
    @Mapping(source = "paciente.apellidos", target = "pacienteApellidos")
    @Mapping(source = "paciente.dni",     target = "pacienteDni")
    @Mapping(source = "medico.id",        target = "medicoId")
    @Mapping(source = "medico.nombres",   target = "medicoNombres")
    @Mapping(source = "medico.apellidos", target = "medicoApellidos")
    ConsultaResponseDTO toResponseDTO(Consulta entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "cita",     ignore = true)
    @Mapping(target = "paciente", ignore = true)
    @Mapping(target = "medico",   ignore = true)
    void updateEntityFromDTO(ConsultaRequestDTO dto, @MappingTarget Consulta entity);
}

