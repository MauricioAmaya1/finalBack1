package MauricioAmaya.finalBackEnd1.controller;


import MauricioAmaya.finalBackEnd1.entity.Paciente;
import MauricioAmaya.finalBackEnd1.entity.Turno;
import MauricioAmaya.finalBackEnd1.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")

public class TurnoController {

    private TurnoService turnoService;
    @Autowired
    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping
    public ResponseEntity<Turno> guardarTurno(@RequestBody Turno turno){
        return ResponseEntity.ok(turnoService.guardarTurno(turno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id){
        Optional<Turno> turnoBuscado = turnoService.buscarTurno(id);
        if (turnoBuscado.isPresent()){
            turnoService.eliminarTurno(id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Se elimino el turno " +
                    "con id= "+id);
        }
        else{
            return ResponseEntity.badRequest().body("No se encuentra un turno con id= "
                    +id+" . Verificar el ingreso.");
        }
    }


    @PutMapping
    public ResponseEntity<String> actualizarTurno (@RequestBody Turno turno){
        Optional<Turno> turnoBuscado = turnoService.buscarTurno(turno.getId());
        if (turnoBuscado.isPresent()){
            turnoService.actualizarTurno(turno);
            return ResponseEntity.ok("Se actulizó el turno con " +
                    "id "+turno.getId());
        }
        else{
            return ResponseEntity.badRequest().body("El turno con id= "+
                    turno.getId()+" no existe en la BD." +
                    "No se puede actualizar");
        }
    }

    @GetMapping
    public ResponseEntity<List<Turno>> buscarTodosTurnos(){
        return ResponseEntity.ok(turnoService.buscarTodosTurnos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurno(@PathVariable Long id){
        Optional<Turno> turnoBuscado= turnoService.buscarTurno(id);
        if (turnoBuscado.isPresent()){
            return ResponseEntity.ok(turnoBuscado.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }








}
