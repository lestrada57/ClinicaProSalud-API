package idat.edu.prosalud.mapper;

import idat.edu.prosalud.dto.request.UsuarioRequestDTO;
import idat.edu.prosalud.dto.response.UsuarioResponseDTO;
import idat.edu.prosalud.entity.Usuario;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioRequestDTO dto);

    UsuarioResponseDTO toResponseDTO(Usuario entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(UsuarioRequestDTO dto, @MappingTarget Usuario entity);
}

