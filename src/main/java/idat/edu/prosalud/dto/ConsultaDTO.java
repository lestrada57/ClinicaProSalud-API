package idat.edu.prosalud.dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ConsultaDTO {
    private Long id;
    private Long citaId;
    private Long pacienteId;
    private Long medicoId;
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

