package MauricioAmaya.finalBackEnd1.repository;

import MauricioAmaya.finalBackEnd1.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
