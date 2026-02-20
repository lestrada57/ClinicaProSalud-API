package idat.edu.prosalud.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;

@Entity
@Table(name = "horarios_medicos", indexes = {
        @Index(name = "idx_horarios_medico_id",  columnList = "medico_id"),
        @Index(name = "idx_horarios_dia_semana", columnList = "dia_semana"),
        @UniqueConstraint(name = "uq_horario_medico_dia_hora",
                columnNames = {"medico_id", "dia_semana", "hora_inicio"})
})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class HorarioMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @Column(name = "dia_semana", nullable = false)
    private Integer diaSemana;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    @Column(nullable = false, columnDefinition = "BIT DEFAULT 1")
    private Boolean activo;

    @PrePersist
    protected void onCreate() {
        if (activo == null) activo = true;
    }
}

