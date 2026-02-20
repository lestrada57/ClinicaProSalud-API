package idat.edu.prosalud.dto.response;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EspecialidadResponseDTO {
    private Long id;
    private String nombre;
    private Boolean activo;
}

