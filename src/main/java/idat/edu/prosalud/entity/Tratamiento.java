package idat.edu.prosalud.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tratamientos", indexes = {
        @Index(name = "idx_tratamientos_consulta_id",   columnList = "consulta_id"),
        @Index(name = "idx_tratamientos_fecha_inicio",  columnList = "fecha_inicio")
})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Tratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consulta_id", nullable = false)
    private Consulta consulta;

    @Column(length = 255, nullable = false)
    private String descripcion;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String indicaciones;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(length = 50)
    private String tipo;

    @Column(nullable = false, columnDefinition = "BIT DEFAULT 1")
    private Boolean activo;

    @Column(name = "fecha_creacion", nullable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaCreacion;

    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
        if (activo == null) activo = true;
    }
}

