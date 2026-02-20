package idat.edu.prosalud.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pacientes", indexes = {
        @Index(name = "idx_pacientes_dni",        columnList = "dni"),
        @Index(name = "idx_pacientes_usuario_id", columnList = "usuario_id"),
        @Index(name = "idx_pacientes_nombre",     columnList = "apellidos, nombres")
})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", unique = true)
    private Usuario usuario;

    @Column(length = 100, nullable = false)
    private String nombres;

    @Column(length = 100, nullable = false)
    private String apellidos;

    @Column(length = 20, unique = true, nullable = false)
    private String dni;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(length = 10)
    private String genero;

    @Column(length = 255)
    private String direccion;

    @Column(length = 20)
    private String telefono;

    @Column(name = "tipo_sangre", length = 5)
    private String tipoSangre;

    @Column(name = "contacto_emergencia", length = 100)
    private String contactoEmergencia;

    @Column(name = "telefono_emergencia", length = 20)
    private String telefonoEmergencia;

    @Column(nullable = false, columnDefinition = "BIT DEFAULT 1")
    private Boolean activo;

    @Column(name = "fecha_registro", nullable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaRegistro;

    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
        if (activo == null) activo = true;
    }
}

