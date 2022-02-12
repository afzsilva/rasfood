package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;
import java.util.List;

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

    public List<Cardapio> consultarTodos(){
        String sql = "SELECT c FROM Cardapio c";
        return this.entityManager.createQuery(sql,Cardapio.class).getResultList();
    }

    public void atualisar(final Cardapio prato){
        this.entityManager.merge(prato);
    }

    public void excluir(final Cardapio prato){
        this.entityManager.remove(prato);
    }

}
