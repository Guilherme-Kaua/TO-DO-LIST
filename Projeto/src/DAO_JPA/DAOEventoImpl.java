package DAO_JPA;

import Principais.Evento;
import Utils.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DAOEventoImpl implements DAOEvento {

    @Override
    public void salvar(Evento evento) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(evento);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao salvar Evento: ", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Evento> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("FROM Evento", Evento.class)
                    .getResultList();
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao listar Eventos: ", e);
        } finally {
            em.close();
        }
    }

    @Override
    public Evento buscar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Evento.class, id);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao buscar Evento: ", e);
        } finally {
            em.close();
        }
    }

    @Override
    public void atualizar(Evento evento) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(evento);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao atualizar Evento: ", e);
        } finally {
            em.close();
        }
    }

    @Override
    public void deletar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Evento evento = em.find(Evento.class, id);
            if (evento != null) {
                em.remove(evento);
            }
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao deletar Evento: ", e);
        } finally {
            em.close();
        }
    }
}