package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {

    EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria){
        entityManager.persist(categoria);
    }

    public Categoria consultar(final Integer id){
        return entityManager.find(Categoria.class,id);
    }

    public void atualisar(Categoria categoria){
        entityManager.merge(categoria);
    }

    public void excluir(Categoria categoria){
        entityManager.remove(categoria);
    }

    public List<Categoria> consultarTodos(){
        String jpql = "SELECT c FROM Categoria c";
        return entityManager.createQuery(jpql,Categoria.class).getResultList();
    }

}
