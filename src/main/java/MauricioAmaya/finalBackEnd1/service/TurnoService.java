package MauricioAmaya.finalBackEnd1.service;

import MauricioAmaya.finalBackEnd1.dto.TurnoDTO;
import MauricioAmaya.finalBackEnd1.entity.Odontologo;
import MauricioAmaya.finalBackEnd1.entity.Paciente;
import MauricioAmaya.finalBackEnd1.entity.Turno;
import MauricioAmaya.finalBackEnd1.repository.TurnoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    //PONER LOS LOGGER EN TODOS LOS SERVICE

    private TurnoRepository turnoRepository;

    private static final Logger LOGGER = Logger.getLogger(TurnoService.class);
    @Autowired
    public TurnoService (TurnoRepository turnoRepository){
        this.turnoRepository = turnoRepository;
    }

    public TurnoDTO guardarTurno (TurnoDTO turnoDTO){
        LOGGER.info("Se inicio un guardado de turno");

        Turno turnoAGuardar = turnoDtoATurno(turnoDTO);
        Turno turnoGuardado = turnoRepository.save(turnoAGuardar);

        return turnoATurnoDTO(turnoGuardado);
    }
    public void eliminarTurno(Long id){
        LOGGER.info("Se inicio una eliminacion de turno");
        turnoRepository.deleteById(id);
    }
    public void actualizarTurno(TurnoDTO turnoDTO){
        LOGGER.info("Se inicio una actualizacion de turno");
        Turno turnoAActualizat= turnoDtoATurno(turnoDTO);
        turnoRepository.save(turnoAActualizat);
    }

    public Optional<TurnoDTO> buscarTurno(Long id){
        LOGGER.info("Se inicio una busqueda por id de turno");
        Optional<Turno> turnoBuscado = turnoRepository.findById(id);
        if (turnoBuscado.isPresent()){
            return Optional.of(turnoATurnoDTO(turnoBuscado.get())); // con el .get sacamos el opcional del turno
        }else{
            // no se encontro el turno
            return Optional.empty();
        }
    }

    public List<TurnoDTO> buscarTodosTurnos(){
        LOGGER.info("Se inicio una busqueda de turnos");

        List<Turno> turnosEncontrados = turnoRepository.findAll();
        List<TurnoDTO> respuesta =  new ArrayList<>();

        for (Turno t:turnosEncontrados) {
            respuesta.add(turnoATurnoDTO(t));
        }
        return respuesta;
    }



    private TurnoDTO turnoATurnoDTO(Turno turno){
        // convertir turno en turno dto
        TurnoDTO respuesta = new TurnoDTO();
        respuesta.setId(turno.getId());
        respuesta.setFecha(turno.getFecha());
        respuesta.setOdontologo(turno.getOdontologo());
        respuesta.setPaciente(turno.getPaciente());

        return respuesta;
    }

    private Turno turnoDtoATurno(TurnoDTO turnoDTO){
        // convertir turno dto en turno

        Turno turno = new Turno();
        Paciente paciente = new Paciente();
        Odontologo odontologo = new Odontologo();
        // cargar elemementos
        paciente.setId(turnoDTO.getPaciente().getId());
        odontologo.setId(turnoDTO.getOdontologo().getId());
        turno.setFecha(turnoDTO.getFecha());
        // asociar elelmentmos
        turno.setPaciente(paciente);
        turno.setOdontologo(odontologo);
        // salida
        return turno;

    }



}
