package DAO_JPA;

import Principais.Evento;
import Utils.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.Set;

public class DAOEventoImpl implements DAOEvento{

    private final EntityManager em = JPAUtil.getEntityManager();

    @Override
    public void salvar(Evento evento) {

    }

    @Override
    public Set<Evento> listarTodos() {
        return Set.of();
    }

    @Override
    public Evento buscarPorId(Long id) {
        return null;
    }

    @Override
    public void atualizar(Evento evento) {

    }

    @Override
    public void deletar(Long id) {

    }
}
