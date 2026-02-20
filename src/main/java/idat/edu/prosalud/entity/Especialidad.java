package idat.edu.prosalud.entity;
}
    }
        if (activo == null) activo = true;
    protected void onCreate() {
    @PrePersist

    private Boolean activo;
    @Column(columnDefinition = "BIT DEFAULT 1")

    private String nombre;
    @Column(length = 150, nullable = false)

    private Long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

public class Especialidad {
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "especialidades")
@Entity

import java.time.LocalDateTime;
import lombok.*;
import jakarta.persistence.*;


