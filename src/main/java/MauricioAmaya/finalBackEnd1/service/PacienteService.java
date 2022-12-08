package MauricioAmaya.finalBackEnd1.service;


import MauricioAmaya.finalBackEnd1.entity.Paciente;
import MauricioAmaya.finalBackEnd1.repository.PacienteRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    //PONER LOS LOGGER EN TODOS LOS SERVICE
    private PacienteRepository pacienteRepository;

    private static final Logger LOGGER = Logger.getLogger(PacienteService.class);
    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente guardarPaciente (Paciente paciente){
        LOGGER.info("Se inicio un guardado de paciente con id: " + paciente.getId() );
        return pacienteRepository.save(paciente);
    }
    public void eliminarPaciente(Long id){
        LOGGER.info("Se inicio una eliminacion de paciente con id: " + id);
        pacienteRepository.deleteById(id);
    }
    public void actualizarPaciente(Paciente paciente){
        LOGGER.info("Se inicio una actualizacion de paciente con id: " + paciente.getId() );
        pacienteRepository.save(paciente);
    }
    public Optional<Paciente> buscarPaciente(Long id){
        LOGGER.info("Se inicio una busqueda por id de turno");
        return pacienteRepository.findById(id);
    }
    public List<Paciente> buscarTodosPacientes(){
        LOGGER.info("Se inicio una busqueda de turnos");
        return pacienteRepository.findAll();
    }

}
