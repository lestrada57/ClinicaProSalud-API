package idat.edu.prosalud.mapper;

import idat.edu.prosalud.dto.ConsultaDTO;
import idat.edu.prosalud.entity.Consulta;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {

    @Mapping(target = "cita",     ignore = true)
    @Mapping(target = "paciente", ignore = true)
    @Mapping(target = "medico",   ignore = true)
    Consulta toEntity(ConsultaDTO dto);

    @Mapping(source = "cita.id",     target = "citaId")
    @Mapping(source = "paciente.id", target = "pacienteId")
    @Mapping(source = "medico.id",   target = "medicoId")
    ConsultaDTO toDTO(Consulta entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "cita",     ignore = true)
    @Mapping(target = "paciente", ignore = true)
    @Mapping(target = "medico",   ignore = true)
    void updateEntityFromDTO(ConsultaDTO dto, @MappingTarget Consulta entity);
}
