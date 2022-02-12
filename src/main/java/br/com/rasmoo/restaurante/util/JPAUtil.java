package br.com.rasmoo.restaurante.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory RASSFOOD = Persistence.createEntityManagerFactory("rasFood");
    public static EntityManager getEntityManageRasFood(){
        return RASSFOOD.createEntityManager();
    }
}
