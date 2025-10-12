package Principais;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
@Entity
@Table(name = "Tarefas")
public class Tarefa extends DadosComuns{

    @Column
    private int nivel;

    public Tarefa(String titulo, String descricao, LocalDate dataLimite){
        if (titulo.isEmpty() || descricao.isEmpty()){
            throw new NullPointerException();
        }
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        setDataLimite(dataLimite);
        this.setNivel(atualizarNivel());
    }


    public boolean equals(Tarefa outro) {
        return (outro.getId() == getId());
    }

    public String toString() {
        return "Título da  tarefa: " + getTitulo() + ", Que dura até: " + getDataLimite();
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int n) {
        nivel = n;
    }

    public int atualizarNivel() {
        LocalDate hoje = LocalDate.now();
        long diasRestantes = ChronoUnit.DAYS.between(hoje, getDataLimite());

        if (diasRestantes < 0) {
            // Atrasado
            return 6;
        } else if (diasRestantes <= 1) {
            // Inclui hoje (0 dias) e amanhã (1 dia)
            // Crítico
            return 5;
        } else if (diasRestantes <= 7) {
            // Urgente
            return 4;
        } else if (diasRestantes <= 30) {
            // Atenção
            return 3;
        } else if (diasRestantes <= 90) {
            // Normal
            return 2;
        } else {
            // Baixo
            return 1;
        }
    }
    }
