package idat.edu.prosalud.dto.request;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class MedicoRequestDTO {
    private Long usuarioId;
    private String nombres;
    private String apellidos;
    private String dni;
    private Long especialidadId;
    private String telefono;
    private Integer duracionCitaMinutos;
    private Boolean activo;
}

