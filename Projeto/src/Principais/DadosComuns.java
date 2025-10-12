package Principais;

import jakarta.persistence.*;

import java.time.LocalDate;

@MappedSuperclass
public abstract class DadosComuns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = System.currentTimeMillis();
    @Column(nullable = false, name ="Titulo" )
    private String titulo;
    @Column
    private String descricao;
    @Column
    private LocalDate DataLimite;
    @Column
    private LocalDate DataCadastro = LocalDate.now();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        DataCadastro = dataCadastro;
    }

    public LocalDate getDataLimite() {
        return DataLimite;
    }

    public void setDataLimite(LocalDate dataLimite) {
        DataLimite = dataLimite;
    }
}
