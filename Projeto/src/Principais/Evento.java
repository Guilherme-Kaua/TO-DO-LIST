package Principais;

import java.time.LocalDate;

public class Evento {

    private long id = System.currentTimeMillis();
    private String descricao;
    private String titulo;
    private LocalDate dataCadastro;
    private LocalDate dataEvento;

    public Evento(String titulo, String descricao, LocalDate dataEvento){
        if (titulo.isEmpty() || descricao.isEmpty()){
            throw new NullPointerException();
        }
        if (dataEvento != null && dataEvento.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data do evento não pode ser no passado");
        }

        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEvento=dataEvento;
        this.dataCadastro=LocalDate.now();
    }

    public String toString(){
        return "Principais.Evento:"+ " " + titulo + " " + "Acontecerá dia:" + " " + dataEvento;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
