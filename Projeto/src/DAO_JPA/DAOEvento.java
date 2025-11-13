package DAO_JPA;

import Principais.Evento;

import java.util.Set;

public interface DAOEvento {
    // CREATE
    void salvar(Evento evento);

    // READ
    Set<Evento> listarTodos();
    Evento buscarPorId(Long id);

    // UPDATE
    void atualizar(Evento evento);

    // DELETE
    void deletar(Long id);

}
