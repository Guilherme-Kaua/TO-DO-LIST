package DAO_JPA;

import Principais.Evento;

import java.util.List;

public interface DAOEvento {
    // CREATE
    void salvar(Evento evento);

    // READ
    List<Evento> listar();
    Evento buscar(Long id);

    // UPDATE
    void atualizar(Evento evento);

    // DELETE
    void deletar(Long id);

}