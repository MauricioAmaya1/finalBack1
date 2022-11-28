package MauricioAmaya.finalBackEnd1.service;


import MauricioAmaya.finalBackEnd1.entity.Domicilio;
import MauricioAmaya.finalBackEnd1.entity.Paciente;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;

    @Test
    @Order(1)
    public void guardarPacienteTest(){

        Paciente paciente = new Paciente("nombre","ape","402317",
                LocalDate.of(2022,11,28),"mauri@gmail",new Domicilio("gallo",1580,"Rosario","santa fe "));

        Paciente pacienteGuardado = pacienteService.guardarPaciente(paciente);

        Assertions.assertEquals(1L,pacienteGuardado.getId());   // la L es de Long

    }

    @Test
    @Order(2)
    public void buscarPacientePorIdTest(){

        Long idABuscar = 1L; // la L es de Long

        Optional<Paciente> pacienteBuscado = pacienteService.buscarPaciente(idABuscar);

        Assertions.assertNotNull(pacienteBuscado.get());

    }

    @Test
    @Order(3)
    public void buscarTodosLosPacienteTest(){

        List<Paciente> pacientes = pacienteService.buscarTodosPacientes();

        Integer cantidadEsperada = 1; // ahora sabemos que hay uno pero es segun el caso

        Assertions.assertEquals(cantidadEsperada,pacientes.size());

    }


    @Test
    @Order(4)
    public void actualizarPacienteTest(){

        Paciente pacienteActualizar = new Paciente(1L,"nombre","ape","402317",
                LocalDate.of(2022,11,28),"mauri@gmail",new Domicilio(1L,"gallo",1580,"Rosario","santa fe "));

        pacienteService.actualizarPaciente(pacienteActualizar);

        Optional<Paciente> pacienteActualizado = pacienteService.buscarPaciente(pacienteActualizar.getId());

        Assertions.assertEquals("nombre",pacienteActualizado.get().getNombre());

    }

    @Test
    @Order(5)
    public void eliminarPacienteTest(){

        Long idAEliminar = 1L;

        pacienteService.eliminarPaciente(idAEliminar);

        Optional<Paciente> pacienteEliminado = pacienteService.buscarPaciente(idAEliminar);

        Assertions.assertFalse(pacienteEliminado.isPresent()); // deberia dar falso si no esta

    }









}
