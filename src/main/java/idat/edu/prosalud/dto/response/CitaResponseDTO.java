package idat.edu.prosalud.dto.response;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CitaResponseDTO {
    private Long id;
    private Long pacienteId;
    private String pacienteNombres;
    private String pacienteApellidos;
    private String pacienteDni;
    private Long medicoId;
    private String medicoNombres;
    private String medicoApellidos;
    private String especialidadNombre;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String estado;
    private String motivoConsulta;
    private String observacionesRecepcion;
    private String motivoCancelacion;
    private Long recepcionistaRegistroId;
    private String recepcionistaRegistroNombres;
    private Long recepcionistaAtencionId;
    private String recepcionistaAtencionNombres;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}

