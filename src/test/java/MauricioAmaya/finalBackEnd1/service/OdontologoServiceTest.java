package MauricioAmaya.finalBackEnd1.service;

import MauricioAmaya.finalBackEnd1.entity.Odontologo;
import MauricioAmaya.finalBackEnd1.entity.Paciente;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    void guardarOdontologo() {

        Odontologo odontologo = new Odontologo("Mauricio","Amaya",20);
        Odontologo odontologoAGuardar = odontologoService.guardarOdontologo(odontologo);
        Assertions.assertEquals(1L,odontologoAGuardar.getId());
    }

    @Test
    @Order(2)
    void buscarOdontologo() {
        Long idABuscar=1L;
        Optional<Odontologo> odontologBuscado=odontologoService.buscarOdontologo(idABuscar);
        Assertions.assertNotNull(odontologBuscado.get());
    }

    @Test
    @Order(3)
    void buscarTodosOdontologos() {
        List<Odontologo> odontologos= odontologoService.buscarTodosOdontologos();
        Integer cantidadEsperada=1;
        assertEquals(cantidadEsperada,odontologos.size());
    }

    @Test
    @Order(4)
    void actualizarOdontologo() {

        Odontologo odontologoAActualizar = new Odontologo(1L,"Mauricio","Amaya",10);
        odontologoService.actualizarOdontologo(odontologoAActualizar);
        Optional<Odontologo> odontologoActualizado= odontologoService.buscarOdontologo(odontologoAActualizar.getId());
        assertEquals("Mauricio",odontologoActualizado.get().getNombre());

    }

    @Test
    @Order(5)
    void eliminarOdontologo() {

        Long idAEliminar=1L;
        odontologoService.eliminarOdontologo(idAEliminar);
        Optional<Odontologo> odontologoEliminado =odontologoService.buscarOdontologo(idAEliminar);
        Assertions.assertFalse(odontologoEliminado.isPresent());

    }


}