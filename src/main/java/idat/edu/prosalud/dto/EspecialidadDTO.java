package idat.edu.prosalud.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EspecialidadDTO {
    private Long id;
    private String nombre;
    private Boolean activo;
}

