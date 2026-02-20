package idat.edu.prosalud.dto.response;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class RecepcionistaResponseDTO {
    private Long id;
    private Long usuarioId;
    private String usuarioUsername;
    private String nombres;
    private String apellidos;
    private String dni;
    private String telefono;
    private String turno;
    private Boolean activo;
    private LocalDateTime fechaCreacion;
}

