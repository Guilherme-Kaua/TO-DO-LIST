package DAO_JPA;


import Principais.Tarefa;

import java.util.Set;

public interface DAOTarefa {

    // CREATE
    Tarefa salvar(Tarefa tarefa);

    // READ
    Set<Tarefa> listarTodos();
    Tarefa buscarPorId(Long id);

    // UPDATE
    void atualizar(Tarefa tarefa);

    // DELETE
    void deletar(Long id);
}
