package idat.edu.prosalud.mapper;

import idat.edu.prosalud.dto.RecepcionistaDTO;
import idat.edu.prosalud.entity.Recepcionista;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface RecepcionistaMapper {

    @Mapping(target = "usuario", ignore = true)
    Recepcionista toEntity(RecepcionistaDTO dto);

    @Mapping(source = "usuario.id", target = "usuarioId")
    RecepcionistaDTO toDTO(Recepcionista entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "usuario", ignore = true)
    void updateEntityFromDTO(RecepcionistaDTO dto, @MappingTarget Recepcionista entity);
}
