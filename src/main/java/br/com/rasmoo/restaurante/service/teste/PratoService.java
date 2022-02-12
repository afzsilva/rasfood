package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.entity.Prato;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class PratoService {
    public static void main(String[] args) {

        //TRANSIENT
        Prato risoto = new Prato();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));


        EntityManager entityManager = JPAUtil.getEntityManageRasFood();
        entityManager.getTransaction().begin();

        //MANAGED
        entityManager.persist(risoto);
        entityManager.getTransaction().commit();

        //DETACHED
        entityManager.close();

    }//main
}
