package MauricioAmaya.finalBackEnd1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Turno {

    @Id
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    @Getter
    private Long id;

    @Getter @Setter
    @ManyToOne()
    @JoinColumn(name = "paciente_id", nullable = false)
    @JsonIgnoreProperties({"turnos"})
    private Paciente paciente;

    @Getter @Setter
    @ManyToOne()
    @JoinColumn(name = "odontologo_id", nullable = false)
    @JsonIgnoreProperties({"turnos"})
    private Odontologo odontologo;

    @Getter @Setter
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