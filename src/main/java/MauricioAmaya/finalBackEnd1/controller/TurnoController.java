package MauricioAmaya.finalBackEnd1.controller;


import MauricioAmaya.finalBackEnd1.dto.TurnoDTO;
import MauricioAmaya.finalBackEnd1.entity.Odontologo;
import MauricioAmaya.finalBackEnd1.entity.Paciente;
import MauricioAmaya.finalBackEnd1.exceptions.ResourcesNotFoundException;
import MauricioAmaya.finalBackEnd1.service.OdontologoService;
import MauricioAmaya.finalBackEnd1.service.PacienteService;
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
    private PacienteService pacienteService;
    private OdontologoService odontologoService;

    @Autowired
    public TurnoController(TurnoService turnoService, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @PostMapping()
    public ResponseEntity<TurnoDTO> guardarTurno(@RequestBody TurnoDTO turnoDTO){
            return ResponseEntity.ok(turnoService.guardarTurno(turnoDTO));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) throws ResourcesNotFoundException {
        Optional<TurnoDTO> turnoBuscado = turnoService.buscarTurno(id);
        if (turnoBuscado.isPresent()){
            turnoService.eliminarTurno(id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Se elimino el turno " +
                    "con id= "+id);
        }
        else{
            throw new ResourcesNotFoundException("No se encuentra un turno con id= "
                    +id+" . Verificar el ingreso.");
        }
    }


    @PutMapping
    public ResponseEntity<String> actualizarTurno (@RequestBody TurnoDTO turno){
        Optional<TurnoDTO> turnoBuscado = turnoService.buscarTurno(turno.getId());
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
    public ResponseEntity<List<TurnoDTO>> buscarTodosTurnos(){
        return ResponseEntity.ok(turnoService.buscarTodosTurnos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscarTurno(@PathVariable Long id){
        Optional<TurnoDTO> turnoBuscado= turnoService.buscarTurno(id);
        if (turnoBuscado.isPresent()){
            return ResponseEntity.ok(turnoBuscado.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }








}
