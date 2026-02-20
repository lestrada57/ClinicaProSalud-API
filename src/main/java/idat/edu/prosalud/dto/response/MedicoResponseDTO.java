package idat.edu.prosalud.dto.response;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class MedicoResponseDTO {
    private Long id;
    private Long usuarioId;
    private String usuarioUsername;
    private String nombres;
    private String apellidos;
    private String dni;
    private Long especialidadId;
    private String especialidadNombre;
    private String telefono;
    private Integer duracionCitaMinutos;
    private Boolean activo;
    private LocalDateTime fechaCreacion;
}

