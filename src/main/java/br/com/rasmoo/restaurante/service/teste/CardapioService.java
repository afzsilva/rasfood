package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.*;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        //TRANSIENT
        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Cardapio salmao = new Cardapio();
        salmao.setNome("Salmão ao molho de maracuja");
        salmao.setDescricao("Salmão grelhado ao molho de maracuja");
        salmao.setDisponivel(true);
        salmao.setValor(BigDecimal.valueOf(60.00));

        EntityManager entityManager = JPAUtil.getEntityManageRasFood();
        CardapioDao cardapioDao = new CardapioDao(entityManager);//instancia do dao
        entityManager.getTransaction().begin();

        //MANAGED
        cardapioDao.cadastrar(risoto);
        entityManager.flush();

        cardapioDao.cadastrar(salmao);//insert
        entityManager.flush();

        //System.out.println("Prato consultado: "+ cardapioDao.consultar(1));

        //cardapioDao.excluir(salmao);//delete
        //System.out.println("Prato consultado: "+ cardapioDao.consultar(2));//null

        cardapioDao.consultarTodos().forEach(e-> System.out.println("Retornado : "+e));

        //DETACHED
        entityManager.clear();

        //apos estatus DETACHED
        /*salmao.setValor(BigDecimal.valueOf(75.50));
        cardapioDao.atualisar(salmao);
        System.out.println("Prato consultado foi: "+ cardapioDao.consultar(2));//null
*/
    }//main
}
