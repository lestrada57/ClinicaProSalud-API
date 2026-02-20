package idat.edu.prosalud.dto.response;

import lombok.*;
import java.time.LocalTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class HorarioMedicoResponseDTO {
    private Long id;
    private Long medicoId;
    private String medicoNombres;
    private String medicoApellidos;
    private Integer diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Boolean activo;
}

