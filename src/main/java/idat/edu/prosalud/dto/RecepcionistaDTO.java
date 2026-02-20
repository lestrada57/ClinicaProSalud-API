package idat.edu.prosalud.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class RecepcionistaDTO {
    private Long id;
    private Long usuarioId;
    private String nombres;
    private String apellidos;
    private String dni;
    private String telefono;
    private String turno;
    private Boolean activo;
    private LocalDateTime fechaCreacion;
}

