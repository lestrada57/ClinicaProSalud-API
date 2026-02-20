package idat.edu.prosalud.dto.response;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ConsultaResponseDTO {
    private Long id;
    private Long citaId;
    private Long pacienteId;
    private String pacienteNombres;
    private String pacienteApellidos;
    private String pacienteDni;
    private Long medicoId;
    private String medicoNombres;
    private String medicoApellidos;
    private BigDecimal peso;
    private BigDecimal altura;
    private String presionArterial;
    private BigDecimal temperatura;
    private Integer frecuenciaCardiaca;
    private String sintomas;
    private String diagnostico;
    private String condicionActual;
    private String observaciones;
    private String recomendaciones;
    private LocalDateTime fechaConsulta;
}

