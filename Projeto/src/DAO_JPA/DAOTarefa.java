package DAO_JPA;


import Principais.Tarefa;

import java.util.List;

public interface DAOTarefa {

    // CREATE
    void salvar(Tarefa tarefa);

    // READ
    List<Tarefa> listar();
    Tarefa buscar(Long id);

    // UPDATE
    void atualizar(Tarefa tarefa);

    // DELETE
    void deletar(Long id);
}