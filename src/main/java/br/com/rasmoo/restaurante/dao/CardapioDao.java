package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;

/**
 * CRUD
 * Create
 * Read
 * Update
 * Delete
 */
public class CardapioDao {

    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public void cadastrar(Cardapio prato){
        entityManager.persist(prato);
        System.out.println("Entidade cadastrada >>>"+prato);
    }

    public Cardapio consultar(final Integer id){
        return this.entityManager.find(Cardapio.class,id);
    }

    public void atualisar(final Cardapio prato){
        this.entityManager.merge(prato);
    }

    public void excluir(final Cardapio prato){
        this.entityManager.remove(prato);
    }

}
