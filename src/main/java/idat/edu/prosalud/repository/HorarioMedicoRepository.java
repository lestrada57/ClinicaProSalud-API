package idat.edu.prosalud.repository;

import idat.edu.prosalud.entity.HorarioMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioMedicoRepository extends JpaRepository<HorarioMedico, Long> {

    List<HorarioMedico> findByMedicoId(Long medicoId);

    List<HorarioMedico> findByMedicoIdAndActivoTrue(Long medicoId);

    List<HorarioMedico> findByMedicoIdAndDiaSemana(Long medicoId, Integer diaSemana);

    boolean existsByMedicoIdAndDiaSemana(Long medicoId, Integer diaSemana);
}

