package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.PratoDao;
import br.com.rasmoo.restaurante.entity.Prato;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PratoService {
    public static void main(String[] args) {

        //TRANSIENT
        Prato risoto = new Prato();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Prato salmao = new Prato();
        salmao.setNome("Salmão ao molho de maracuja");
        salmao.setDescricao("Salmão grelhado ao molho de maracuja");
        salmao.setDisponivel(true);
        salmao.setValor(BigDecimal.valueOf(60.00));


        EntityManager entityManager = JPAUtil.getEntityManageRasFood();
        PratoDao pratoDao = new PratoDao(entityManager);//instancia do dao
        entityManager.getTransaction().begin();

        //MANAGED
        pratoDao.cadastrar(risoto);
        pratoDao.cadastrar(salmao);//insert

        System.out.println("Prato consultado: "+pratoDao.consultar(2));

        pratoDao.excluir(salmao);//delete
        System.out.println("Prato consultado: "+pratoDao.consultar(2));//null


        entityManager.getTransaction().commit();

        //DETACHED
        entityManager.close();

    }//main
}
