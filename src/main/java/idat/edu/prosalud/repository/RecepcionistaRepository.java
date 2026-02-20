package idat.edu.prosalud.repository;

import idat.edu.prosalud.entity.Recepcionista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecepcionistaRepository extends JpaRepository<Recepcionista, Long> {

    Optional<Recepcionista> findByDni(String dni);

    boolean existsByDni(String dni);

    List<Recepcionista> findByActivoTrue();

    List<Recepcionista> findByTurno(String turno);
}

