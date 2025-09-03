package Principais;

import java.time.LocalDate;

public abstract class DadosComuns {
    private long id = System.currentTimeMillis();
    private String titulo;
    private String descricao;
    private LocalDate DataLimite;
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
