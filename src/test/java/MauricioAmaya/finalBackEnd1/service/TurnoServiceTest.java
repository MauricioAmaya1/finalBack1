package MauricioAmaya.finalBackEnd1.service;

import MauricioAmaya.finalBackEnd1.dto.TurnoDTO;
import MauricioAmaya.finalBackEnd1.entity.Domicilio;
import MauricioAmaya.finalBackEnd1.entity.Odontologo;
import MauricioAmaya.finalBackEnd1.entity.Paciente;
import MauricioAmaya.finalBackEnd1.entity.Turno;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class TurnoServiceTest {

    private TurnoService turnoService;

    @Test
    @Order(1)
    void guardarTurno() {

        Paciente paciente = new Paciente("Rodolfo","Baspineiro","5161", LocalDate.of(2022,11,28),"prueba@gmail.com",
                new Domicilio("Calle a",548,"Salta Capital","Salta"));
        Odontologo odontologo = new Odontologo("Mauricio","Amaya",10);

        TurnoDTO turno = new TurnoDTO();
        turno.setOdontologo(odontologo);
        turno.setPaciente(paciente);
        turno.setFecha(LocalDate.of(2022,10,10));

        TurnoDTO turnoDTOGuardado = turnoService.guardarTurno(turno);

        Assertions.assertEquals(1L,turnoDTOGuardado.getId());


    }

    @Test
    @Order(2)
    void buscarTurno() {

        Long idABuscar = 1L;
        Optional<TurnoDTO> turnoBuscado=turnoService.buscarTurno(idABuscar);
        Assertions.assertNotNull(turnoBuscado.get());
    }

    @Test
    @Order(3)
    void buscarTodosTurnos() {

        List<TurnoDTO> turnoDTOS = turnoService.buscarTodosTurnos();
        Integer cantidadEsperada = 1;
        assertEquals(cantidadEsperada,turnoDTOS.size());

    }

    @Test
    @Order(4)
    void actualizarTurno() {
    }


    @Test
    @Order(5)
    void eliminarTurno() {

        Long idAEliminar = 1L;
        turnoService.eliminarTurno(idAEliminar);
        Optional<TurnoDTO> turnoDTO = turnoService.buscarTurno(idAEliminar);
        Assertions.assertFalse(turnoDTO.isPresent());

    }

}