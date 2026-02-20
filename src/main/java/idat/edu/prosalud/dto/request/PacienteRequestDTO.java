package idat.edu.prosalud.dto.request;

import lombok.*;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PacienteRequestDTO {
    private Long usuarioId;
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
}

