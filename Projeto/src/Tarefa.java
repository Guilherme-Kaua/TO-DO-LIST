import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tarefa {
    private final long id = System.currentTimeMillis();
    private String titulo;
    private String descricao;
    private LocalDate deadline;
    private final LocalDate dataDeCadastro;



    public Tarefa(String titulo, String descricao, LocalDate deadline) {
        if (titulo.isEmpty() || descricao.isEmpty()){
            throw new NullPointerException();
        }
        this.titulo = titulo;
        this.descricao = descricao;
        this.deadline = deadline;
        dataDeCadastro = LocalDate.from(LocalDateTime.now());
    }

    public boolean equals(Tarefa outro) {
        return (outro.getId() == getId());
    }

    public String toString() {
        return "Título da tarefa: " + titulo +
                ", Que dura até: " + deadline +
                ", Data de Cadastro: " + dataDeCadastro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public long getId() {
        return id;
    }
    
}
