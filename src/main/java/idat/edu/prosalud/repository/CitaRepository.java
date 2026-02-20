package idat.edu.prosalud.repository;

import idat.edu.prosalud.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    List<Cita> findByPacienteId(Long pacienteId);

    List<Cita> findByMedicoId(Long medicoId);

    List<Cita> findByFecha(LocalDate fecha);

    List<Cita> findByMedicoIdAndFecha(Long medicoId, LocalDate fecha);

    List<Cita> findByPacienteIdAndEstado(Long pacienteId, String estado);

    List<Cita> findByEstado(String estado);
}

