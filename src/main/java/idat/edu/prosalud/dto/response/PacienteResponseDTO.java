package idat.edu.prosalud.dto.response;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PacienteResponseDTO {
    private Long id;
    private Long usuarioId;
    private String usuarioUsername;
    private String nombres;
    private String apellidos;
    private String dni;
    private LocalDate fechaNacimiento;
    private String genero;
    private String direccion;
    private String telefono;
    private String tipoSangre;
    private String contactoEmergencia;
    private String telefonoEmergencia;
    private Boolean activo;
    private LocalDateTime fechaRegistro;
}

