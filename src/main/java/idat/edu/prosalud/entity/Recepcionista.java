package idat.edu.prosalud.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "recepcionistas", indexes = {
        @Index(name = "idx_recepcionistas_dni",        columnList = "dni"),
        @Index(name = "idx_recepcionistas_usuario_id", columnList = "usuario_id")
})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Recepcionista {

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

    @Column(length = 20)
    private String telefono;

    @Column(length = 20)
    private String turno;

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

