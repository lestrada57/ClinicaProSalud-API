package idat.edu.prosalud.dto;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CitaDTO {
    private Long id;
    private Long pacienteId;
    private Long medicoId;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String estado;
    private String motivoConsulta;
    private String observacionesRecepcion;
    private String motivoCancelacion;
    private Long recepcionistaRegistroId;
    private Long recepcionistaAtencionId;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}

