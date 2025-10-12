package Principais;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
@Entity
@Table(name = "Eventos")
public class Evento extends DadosComuns{

    public Evento(String titulo, String descricao, LocalDate dataEvento){
        if (titulo.isEmpty() || descricao.isEmpty()){
            throw new NullPointerException();
        }
        if (dataEvento != null && dataEvento.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data do evento não pode ser no passado!");
        }

        setTitulo(titulo);
        setDescricao(descricao);
        setDataLimite(dataEvento);

    }

    public String toString(){
        return "Evento:"+ " " + getTitulo() + " " + "Acontecerá dia:" + " " + getDataCadastro();
    }

}
