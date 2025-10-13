package Principais;

import jakarta.persistence.*;

import java.time.LocalDate;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class DadosComuns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "título", nullable = false, length = 100, unique = true)
    private String titulo;

    @Column(name = "descrição")
    private String descricao;


    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    private LocalDate dataAtualizada;

    @PrePersist
    public void aoCriar(){
        this.dataCadastro = LocalDate.now();
        this.dataAtualizada = LocalDate.now();
    }

    @PreUpdate
    public void aoAtualizar(){
        this.dataAtualizada = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataAtualizada() {
        return dataAtualizada;
    }

    public void setDataAtualizada(LocalDate dataAtualizada) {
        this.dataAtualizada = dataAtualizada;
    }
}
