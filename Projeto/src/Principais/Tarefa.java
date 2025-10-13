package Principais;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Tarefas")
public class Tarefa extends DadosComuns{


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "tarefa",orphanRemoval = true)
    private Set<SubTarefa> subTarefas = new HashSet<>();

    @Column(nullable = false)
    private Integer prioridade;

    @Column(nullable = false)
    private Double percentual;

    private LocalDate dataConcretizacao;

    public Tarefa(){

    }

    @PreUpdate
    public void aoConcluir(){
        if (percentual == 100.0) {
            this.dataConcretizacao = LocalDate.now();
        }
    }

    public Set<SubTarefa> getSubTarefas() {
        return subTarefas;
    }

    public void setSubTarefas(Set<SubTarefa> subTarefas) {
        this.subTarefas = subTarefas;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public Double getPercentual() {
        return percentual;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }

    public LocalDate getDataConcretizacao() {
        return dataConcretizacao;
    }

    public void setDataConcretizacao(LocalDate dataConcretizacao) {
        this.dataConcretizacao = dataConcretizacao;
    }
}
