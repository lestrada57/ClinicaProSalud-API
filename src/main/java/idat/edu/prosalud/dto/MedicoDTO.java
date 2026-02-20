package idat.edu.prosalud.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class MedicoDTO {
    private Long id;
    private Long usuarioId;
    private String nombres;
    private String apellidos;
    private String dni;
    private Long especialidadId;
    private String telefono;
    private Integer duracionCitaMinutos;
    private Boolean activo;
    private LocalDateTime fechaCreacion;
}

