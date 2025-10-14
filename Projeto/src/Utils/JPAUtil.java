package Utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    // 1. A Factory é 'private', 'static' e 'final'.
    //    - static: para que seja única para toda a aplicação.
    //    - final: para que não possa ser alterada depois de inicializada.
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("jpa-pu");

    /**
     * Este é o metodo que o resto da aplicação vai chamar
     * Cada vez que é chamado, ele cria um novo EntityManager
     * @return um novo EntityManager conectado à base de dados
     */
    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

}
