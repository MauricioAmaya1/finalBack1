package MauricioAmaya.finalBackEnd1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter @Setter
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "paciente_id", nullable = false)
    @JsonIgnoreProperties({"turnos"})
    private Paciente paciente;

    @ManyToOne()
    @JoinColumn(name = "odontologo_id", nullable = false)
    @JsonIgnoreProperties({"turnos"})
    private Odontologo odontologo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    public Turno(){
    }

    public Turno(Paciente paciente, Odontologo odontologo, LocalDate fecha) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }


    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo +
                ", fecha=" + fecha +
                '}';
    }

}