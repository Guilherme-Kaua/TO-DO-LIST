package Principais;


import jakarta.persistence.*;

@Entity
@Table(name = "SubTarefas")
public class SubTarefa extends DadosComuns {

    @Column(name = "título",unique = true,nullable = false)
    private String titulo;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tarefa_id")


    @Column(name = "Concluido")
    private Boolean status = false;



    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
