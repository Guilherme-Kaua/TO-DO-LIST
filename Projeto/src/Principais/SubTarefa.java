package Principais;


import jakarta.persistence.*;

@Entity
@Table(name = "SubTarefas")
public class SubTarefa extends DadosComuns {

    @Column(name = "título",unique = true,nullable = false)
    private String titulo;

    @Column(name = "descrição")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "tarefa_id")
    private Tarefa tarefa;

    @Column(name = "Status")
    private Boolean status = false;

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
