package idat.edu.prosalud.dto.request;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EspecialidadRequestDTO {
    private String nombre;
    private Boolean activo;
}

