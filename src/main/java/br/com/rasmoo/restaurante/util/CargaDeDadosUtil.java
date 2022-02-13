package br.com.rasmoo.restaurante.util;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.CategoriaDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.entity.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CargaDeDadosUtil {

    EntityManager entityManager;

    public CargaDeDadosUtil(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public static void cadastrarCategoria(EntityManager entityManager){

        Categoria principal = new Categoria("Principal");
        Categoria salada = new Categoria("Salada");
        Categoria entrada = new Categoria("Entrada");

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        categoriaDao.cadastrar(principal);
        entityManager.flush();

        categoriaDao.cadastrar(salada);
        entityManager.flush();

        categoriaDao.cadastrar(entrada);
        entityManager.flush();
        entityManager.clear();
    }

    public static void cadastrarCardapio(EntityManager entityManager){

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        List<Categoria> categorias = categoriaDao.consultarTodos();
        Cardapio muqueca = new Cardapio("Muqueca","Peixe branco", true, BigDecimal.valueOf(90.00), categorias.get(2));
        Cardapio pizza = new Cardapio("Pizza Muqueca","Peixe branco", true, BigDecimal.valueOf(60.00), categorias.get(2));

        cardapioDao.cadastrar(muqueca);
        cardapioDao.cadastrar(pizza);

        entityManager.getTransaction().commit();
        entityManager.clear();
    }

}
