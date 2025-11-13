package DAO_JPA;


import Utils.JPAUtil;
import jakarta.persistence.EntityManager;

public class DaoFactory {

    private final EntityManager em = JPAUtil.getEntityManager();

    public static DAOTarefa criarTarefaDAO(){
        return new DAOTarefaImpl();
    }

    public static DAOEvento criarEventoDAO(){
        return new DAOEventoImpl();
    }

}
