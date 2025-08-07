import java.time.LocalDate;

public class Tarefa {
    private long id = System.currentTimeMillis();
    private String titulo;
    private String descricao;
    private LocalDate deadline;
    private int nivel;

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Tarefa(String titulo, String descricao, LocalDate deadline, int nivel ) {
        if (titulo.isEmpty() || descricao.isEmpty()){
            throw new NullPointerException();
        }
        this.titulo = titulo;
        this.descricao = descricao;
        this.deadline = deadline;
        this.nivel=nivel;
    }
    public Tarefa(String titulo, String descricao, LocalDate deadline){
        if (titulo.isEmpty() || descricao.isEmpty()){
            throw new NullPointerException();
        }
        this.titulo = titulo;
        this.descricao = descricao;
        this.deadline = deadline;
    }
    public Tarefa(){

    }

    public boolean equals(Tarefa outro) {
        return (outro.getId() == getId());
    }

    public String toString() {
        return "Título da tarefa: " + titulo + ", Que dura até: " + deadline;
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
