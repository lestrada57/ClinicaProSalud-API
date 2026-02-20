package idat.edu.prosalud.dto.request;

import lombok.*;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class TratamientoRequestDTO {
    private Long consultaId;
    private String descripcion;
    private String indicaciones;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String tipo;
    private Boolean activo;
}

