package MauricioAmaya.finalBackEnd1.service;

import MauricioAmaya.finalBackEnd1.entity.Domicilio;
import MauricioAmaya.finalBackEnd1.entity.Paciente;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;


    @Test
    @Order(1)
    public void guardarPacienteTest(){
         Paciente pacienteAGuardar= new Paciente("Rodolfo","Baspineiro","5161", LocalDate.of(2022,11,28),"prueba@gmail.com",
                new Domicilio("Calle a",548,"Salta Capital","Salta"));
        Paciente pacienteGuardado=pacienteService.guardarPaciente(pacienteAGuardar);
        Assertions.assertEquals(1L,pacienteGuardado.getId());
    }
    @Test
    @Order(2)
    public void buscarPacientePorIdTest(){
        Long idABuscar=1L;
        Optional<Paciente> pacienteBuscado=pacienteService.buscarPaciente(idABuscar);
        Assertions.assertNotNull(pacienteBuscado.get());
    }
    @Test
    @Order(3)
    public void buscarPacientesTest(){
        List<Paciente> pacientes= pacienteService.buscarTodosPacientes();
        //por la cantidad de los pacientes
        Integer cantidadEsperada=1;
        assertEquals(cantidadEsperada,pacientes.size());
    }

    @Test
    @Order(4)
    public void actualizarPacienteTest(){
        Paciente pacienteAActualizar= new Paciente(1L,"Ezequiel","Baspineiro","5161", LocalDate.of(2022,11,28),"prueba@gmail.com",
                new Domicilio(1L,"calle",12,"Rosario","santa fe"));
        pacienteService.actualizarPaciente(pacienteAActualizar);
        Optional<Paciente> pacienteActualizado= pacienteService.buscarPaciente(pacienteAActualizar.getId());
        assertEquals("Ezequiel",pacienteActualizado.get().getNombre());
    }

    @Test
    @Order(5)
    public void eliminarPacienteTest(){
        Long idAEliminar=1L;
        pacienteService.eliminarPaciente(idAEliminar);
        Optional<Paciente> pacienteEliminado=pacienteService.buscarPaciente(idAEliminar);
        Assertions.assertFalse(pacienteEliminado.isPresent());
    }

}
