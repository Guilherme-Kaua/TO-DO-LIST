package Principais;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
@Entity
@Table(name = "Eventos")
public class Evento extends DadosComuns{
    private LocalDate dataEvento;
    public Evento(){
    }

    @Column(name = "data_evento",nullable = false,unique = true)
    private LocalDate dataLimite;


    public Evento(String text, String text1, LocalDate deadline) {
        super();
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }
}
