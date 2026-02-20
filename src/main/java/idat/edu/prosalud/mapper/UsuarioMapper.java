package idat.edu.prosalud.mapper;

import idat.edu.prosalud.dto.UsuarioDTO;
import idat.edu.prosalud.entity.Usuario;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO dto);

    UsuarioDTO toDTO(Usuario entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(UsuarioDTO dto, @MappingTarget Usuario entity);
}
