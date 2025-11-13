package DAO_JPA;

import Principais.Tarefa;
import Utils.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.Set;

public class DAOTarefaImpl implements DAOTarefa{

    private final EntityManager em = JPAUtil.getEntityManager();


    @Override
    public Tarefa salvar(Tarefa tarefa) {
        return null;
    }

    @Override
    public Set<Tarefa> listarTodos() {
        return Set.of();
    }

    @Override
    public Tarefa buscarPorId(Long id) {
        return null;
    }

    @Override
    public void atualizar(Tarefa tarefa) {

    }

    @Override
    public void deletar(Long id) {

    }
}
