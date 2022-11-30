package MauricioAmaya.finalBackEnd1.service;

import MauricioAmaya.finalBackEnd1.dto.TurnoDTO;
import MauricioAmaya.finalBackEnd1.entity.Odontologo;
import MauricioAmaya.finalBackEnd1.entity.Paciente;
import MauricioAmaya.finalBackEnd1.entity.Turno;
import MauricioAmaya.finalBackEnd1.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    private TurnoRepository turnoRepository;
    @Autowired
    public TurnoService (TurnoRepository turnoRepository){
        this.turnoRepository = turnoRepository;
    }

    public TurnoDTO guardarTurno (TurnoDTO turnoDTO){

        Turno turnoAGuardar = turnoDtoATurno(turnoDTO);
        Turno turnoGuardado = turnoRepository.save(turnoAGuardar);

        return turnoATurnoDTO(turnoGuardado);
    }
    public void eliminarTurno(Long id){
        turnoRepository.deleteById(id);
    }
    public void actualizarTurno(TurnoDTO turnoDTO){
        Turno turnoAActualizat= turnoDtoATurno(turnoDTO);
        turnoRepository.save(turnoAActualizat);
    }

    public Optional<TurnoDTO> buscarTurno(Long id){
        Optional<Turno> turnoBuscado = turnoRepository.findById(id);
        if (turnoBuscado.isPresent()){
            return Optional.of(turnoATurnoDTO(turnoBuscado.get())); // con el .get sacamos el opcional del turno
        }else{
            // no se encontro el turno
            return Optional.empty();
        }
    }

    public List<TurnoDTO> buscarTodosTurnos(){
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
        respuesta.setOdontologoId(turno.getOdontologo().getId());
        respuesta.setPacienteId(turno.getPaciente().getId());
        return respuesta;
    }

    private Turno turnoDtoATurno(TurnoDTO turnoDTO){
        // convertir turno dto en turno

        Turno turno = new Turno();
        Paciente paciente = new Paciente();
        Odontologo odontologo = new Odontologo();
        // cargar elemementos
        paciente.setId(turnoDTO.getPacienteId());
        odontologo.setId(turnoDTO.getOdontologoId());
        turno.setFecha(turnoDTO.getFecha());
        // asociar elelmentmos
        turno.setPaciente(paciente);
        turno.setOdontologo(odontologo);
        // salida
        return turno;

    }



}
