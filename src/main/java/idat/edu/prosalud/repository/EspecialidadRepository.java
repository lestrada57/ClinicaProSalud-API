package idat.edu.prosalud.repository;

import idat.edu.prosalud.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {

    List<Especialidad> findByActivoTrue();

    boolean existsByNombreIgnoreCase(String nombre);
}

