package idat.edu.prosalud.dto.response;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class TratamientoResponseDTO {
    private Long id;
    private Long consultaId;
    private String descripcion;
    private String indicaciones;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String tipo;
    private Boolean activo;
    private LocalDateTime fechaCreacion;
}

