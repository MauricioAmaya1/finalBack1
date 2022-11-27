package MauricioAmaya.finalBackEnd1.service;

import MauricioAmaya.finalBackEnd1.entity.Turno;
import MauricioAmaya.finalBackEnd1.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    private TurnoRepository turnoRepository;
    @Autowired
    public TurnoService (TurnoRepository turnoRepository){
        this.turnoRepository = turnoRepository;
    }

    public Turno guardarTurno (Turno turno){
        return turnoRepository.save(turno);
    }
    public void eliminarTurno(Long id){
        turnoRepository.deleteById(id);
    }
    public void actualizarTurno(Turno turno){
        turnoRepository.save(turno);
    }
    public Optional<Turno> buscarTurno(Long id){
        return turnoRepository.findById(id);
    }
    public List<Turno> buscarTodosTurnos(){
        return turnoRepository.findAll();
    }





}
