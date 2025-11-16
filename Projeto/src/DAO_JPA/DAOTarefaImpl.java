package DAO_JPA;

import Principais.Tarefa;
import Utils.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class DAOTarefaImpl implements DAOTarefa {

    @Override
    public void salvar(Tarefa tarefa) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(tarefa);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao salvar Tarefa: ", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Tarefa> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("FROM Tarefa", Tarefa.class)
                    .getResultList();
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao listar Tarefas: ", e);
        } finally {
            em.close();
        }
    }

    @Override
    public Tarefa buscar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Tarefa.class, id);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao buscar Tarefa: ", e);
        } finally {
            em.close();
        }
    }

    @Override
    public void atualizar(Tarefa tarefa) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(tarefa);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao atualizar Tarefa: ", e);
        } finally {
            em.close();
        }
    }

    @Override
    public void deletar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Tarefa tarefa = em.find(Tarefa.class, id);
            if (tarefa != null) {
                em.remove(tarefa);
            }
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao deletar Tarefa: ", e);
        } finally {
            em.close();
        }
    }
}