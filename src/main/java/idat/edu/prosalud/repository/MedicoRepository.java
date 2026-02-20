package idat.edu.prosalud.repository;

import idat.edu.prosalud.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Optional<Medico> findByDni(String dni);

    boolean existsByDni(String dni);

    List<Medico> findByActivoTrue();

    List<Medico> findByEspecialidadId(Long especialidadId);

    List<Medico> findByEspecialidadIdAndActivoTrue(Long especialidadId);
}

