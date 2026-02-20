package idat.edu.prosalud.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "consultas", indexes = {
        @Index(name = "idx_consultas_cita_id",        columnList = "cita_id"),
        @Index(name = "idx_consultas_paciente_id",    columnList = "paciente_id"),
        @Index(name = "idx_consultas_medico_id",      columnList = "medico_id"),
        @Index(name = "idx_consultas_fecha_consulta", columnList = "fecha_consulta")
})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cita_id", unique = true, nullable = false)
    private Cita cita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @Column(precision = 5, scale = 2)
    private BigDecimal peso;

    @Column(precision = 5, scale = 2)
    private BigDecimal altura;

    @Column(name = "presion_arterial", length = 20)
    private String presionArterial;

    @Column(precision = 4, scale = 2)
    private BigDecimal temperatura;

    @Column(name = "frecuencia_cardiaca")
    private Integer frecuenciaCardiaca;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String sintomas;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String diagnostico;

    @Column(name = "condicion_actual", columnDefinition = "TEXT")
    private String condicionActual;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @Column(columnDefinition = "TEXT")
    private String recomendaciones;

    @Column(name = "fecha_consulta", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaConsulta;

    @PrePersist
    protected void onCreate() {
        if (fechaConsulta == null) fechaConsulta = LocalDateTime.now();
    }
}

