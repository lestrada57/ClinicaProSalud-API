package idat.edu.prosalud.dto.request;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UsuarioRequestDTO {
    private String username;
    private String password;
    private String email;
    private String role;
    private Boolean activo;
}

