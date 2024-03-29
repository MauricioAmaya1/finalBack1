package MauricioAmaya.finalBackEnd1.controller;

import MauricioAmaya.finalBackEnd1.entity.Paciente;
import MauricioAmaya.finalBackEnd1.exceptions.ResourcesNotFoundException;
import MauricioAmaya.finalBackEnd1.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")

public class PacienteController {
    private PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping()
    public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) throws ResourcesNotFoundException{
        Optional<Paciente> pacienteBuscado=pacienteService.buscarPaciente(id);
        if (pacienteBuscado.isPresent()){
            pacienteService.eliminarPaciente(id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Se elimino al paciente " +
                    "con id= "+id);
        }
        else{

            throw new ResourcesNotFoundException("No se encuentra un paciente con id= "
                    +id+" . Verificar el ingreso.");

            //return ResponseEntity.badRequest().body("No se encuentra un paciente con id= "
                    //+id+" . Verificar el ingreso.");
        }
    }

    @PutMapping
    public ResponseEntity<String> actualizarPaciente(@RequestBody Paciente paciente){

        Optional<Paciente> pacienteBuscado = pacienteService.buscarPaciente(paciente.getId());
        if (pacienteBuscado.isPresent()){
            pacienteService.actualizarPaciente(paciente);
            return ResponseEntity.ok("Se actulizó el paciente con " +
                    "apellido "+paciente.getApellido());
        }
        else{
            return ResponseEntity.badRequest().body("El paciente con id= "+
                    paciente.getId()+" no existe en la BD." +
                    "No se puede actualizar");
        }
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarPacientes(){
        return ResponseEntity.ok(pacienteService.buscarTodosPacientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPacientePorId(@PathVariable Long id){
        Optional<Paciente> pacienteBuscado= pacienteService.buscarPaciente(id);
        if (pacienteBuscado.isPresent()){
            return ResponseEntity.ok(pacienteBuscado.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }


}

