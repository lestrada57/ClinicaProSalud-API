package idat.edu.prosalud.repository;

import idat.edu.prosalud.entity.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {

    List<Tratamiento> findByConsultaId(Long consultaId);

    List<Tratamiento> findByActivoTrue();

    List<Tratamiento> findByTipo(String tipo);

    List<Tratamiento> findByConsultaIdAndActivoTrue(Long consultaId);
}

