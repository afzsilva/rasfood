package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.CategoriaDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.entity.Categoria;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.*;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManageRasFood();
        cadastrarCardapio(entityManager,cadastrarCategoria(entityManager));
    }//main

    private static Categoria cadastrarCategoria(EntityManager entityManager){
        Categoria categoria = new Categoria();
        categoria.setCategoria("Prato Principal");

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        entityManager.getTransaction().begin();

        categoriaDao.cadastrar(categoria);

        entityManager.getTransaction().commit();
        entityManager.clear();

        return categoria;
    }

    private static void cadastrarCardapio(EntityManager entityManager, Categoria categoria){
        //TRANSIENT
        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setCategoria(categoria);
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Cardapio salmao = new Cardapio();
        salmao.setNome("Salmão ao molho de maracuja");
        salmao.setCategoria(categoria);
        salmao.setDescricao("Salmão grelhado ao molho de maracuja");
        salmao.setDisponivel(true);
        salmao.setValor(BigDecimal.valueOf(60.00));

        CardapioDao cardapioDao = new CardapioDao(entityManager);//instancia do dao
        entityManager.getTransaction().begin();
        //MANAGED
        cardapioDao.cadastrar(risoto);
        entityManager.flush();

        cardapioDao.cadastrar(salmao);//insert
        entityManager.flush();
        cardapioDao.consultarTodos().forEach(e-> System.out.println("Retornado : "+e));
        //DETACHED
        entityManager.close();


    }


}
