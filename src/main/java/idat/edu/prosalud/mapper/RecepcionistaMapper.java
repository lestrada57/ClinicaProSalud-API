package idat.edu.prosalud.mapper;

import idat.edu.prosalud.dto.request.RecepcionistaRequestDTO;
import idat.edu.prosalud.dto.response.RecepcionistaResponseDTO;
import idat.edu.prosalud.entity.Recepcionista;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface RecepcionistaMapper {

    @Mapping(target = "usuario", ignore = true)
    Recepcionista toEntity(RecepcionistaRequestDTO dto);

    @Mapping(source = "usuario.id",       target = "usuarioId")
    @Mapping(source = "usuario.username", target = "usuarioUsername")
    RecepcionistaResponseDTO toResponseDTO(Recepcionista entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "usuario", ignore = true)
    void updateEntityFromDTO(RecepcionistaRequestDTO dto, @MappingTarget Recepcionista entity);
}

