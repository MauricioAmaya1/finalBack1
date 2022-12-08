package MauricioAmaya.finalBackEnd1.dto;

import MauricioAmaya.finalBackEnd1.entity.Odontologo;
import MauricioAmaya.finalBackEnd1.entity.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TurnoDTO {

    private Long id;
    private LocalDate fecha;
    private Paciente paciente;
    private Odontologo odontologo;





}