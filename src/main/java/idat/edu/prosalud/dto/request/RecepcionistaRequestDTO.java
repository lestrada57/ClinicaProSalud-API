package idat.edu.prosalud.dto.request;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class RecepcionistaRequestDTO {
    private Long usuarioId;
    private String nombres;
    private String apellidos;
    private String dni;
    private String telefono;
    private String turno;
    private Boolean activo;
}

