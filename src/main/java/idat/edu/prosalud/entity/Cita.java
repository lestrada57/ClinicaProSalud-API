package idat.edu.prosalud.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "citas", indexes = {
        @Index(name = "idx_citas_paciente_id", columnList = "paciente_id"),
        @Index(name = "idx_citas_medico_id",   columnList = "medico_id"),
        @Index(name = "idx_citas_fecha",       columnList = "fecha"),
        @Index(name = "idx_citas_estado",      columnList = "estado"),
        @UniqueConstraint(name = "uq_cita_medico_fecha_hora",
                columnNames = {"medico_id", "fecha", "hora_inicio"})
})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    @Column(length = 20, nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'PROGRAMADA'")
    private String estado;

    @Column(name = "motivo_consulta", columnDefinition = "TEXT")
    private String motivoConsulta;

    @Column(name = "observaciones_recepcion", columnDefinition = "TEXT")
    private String observacionesRecepcion;

    @Column(name = "motivo_cancelacion", columnDefinition = "TEXT")
    private String motivoCancelacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recepcionista_registro_id")
    private Recepcionista recepcionistaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recepcionista_atencion_id")
    private Recepcionista recepcionistaAtencion;

    @Column(name = "fecha_creacion", nullable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion",
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaActualizacion;

    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
        fechaActualizacion = LocalDateTime.now();
        if (estado == null) estado = "PROGRAMADA";
    }

    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = LocalDateTime.now();
    }
}

