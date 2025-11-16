package DAO_JPA;

public class DaoFactory {

    private DaoFactory() {
        // impede instanciação
    }

    public static DAOTarefa criarTarefaDAO() {
        DAOTarefa daoReal = new DAOTarefaImpl();
        return new ProxyTarefa(daoReal);
    }

    public static DAOEvento criarEventoDAO() {
        DAOEvento daoReal = new DAOEventoImpl();
        return new ProxyEvento(daoReal);
    }
}
