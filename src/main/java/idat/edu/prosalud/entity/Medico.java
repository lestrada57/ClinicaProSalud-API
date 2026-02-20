package idat.edu.prosalud.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "medicos", indexes = {
        @Index(name = "idx_medicos_dni",           columnList = "dni"),
        @Index(name = "idx_medicos_usuario_id",    columnList = "usuario_id"),
        @Index(name = "idx_medicos_especialidad",  columnList = "especialidad_id")
})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", unique = true, nullable = false)
    private Usuario usuario;

    @Column(length = 100, nullable = false)
    private String nombres;

    @Column(length = 100, nullable = false)
    private String apellidos;

    @Column(length = 20, unique = true, nullable = false)
    private String dni;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "especialidad_id", nullable = false)
    private Especialidad especialidad;

    @Column(length = 20)
    private String telefono;

    @Column(name = "duracion_cita_minutos", nullable = false, columnDefinition = "INT DEFAULT 30")
    private Integer duracionCitaMinutos;

    @Column(nullable = false, columnDefinition = "BIT DEFAULT 1")
    private Boolean activo;

    @Column(name = "fecha_creacion", nullable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaCreacion;

    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
        if (activo == null) activo = true;
        if (duracionCitaMinutos == null) duracionCitaMinutos = 30;
    }
}

