package br.com.rasmoo.restaurante.service.teste;


import br.com.rasmoo.restaurante.dao.CategoriaDao;
import br.com.rasmoo.restaurante.entity.Categoria;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class CategoriaService {

    public static void main(String[] args) {
        //---------------TRANSIENT---------------
        //instancia e seta entidade
        Categoria categoria = new Categoria();
        categoria.setCategoria("Peixes");

        //Cria um entityManager
        EntityManager entityManager = JPAUtil.getEntityManageRasFood();

        //Intancia DAO (repository)
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        //inicia transações
        entityManager.getTransaction().begin();

        //---------------MANAGED--------------
        //executa operações CRUD
        categoriaDao.cadastrar(categoria);
        System.out.println("Categoria cadastrada "+categoria);
        entityManager.flush();

        Categoria categoriaRetornada = categoriaDao.consultar(1);
        System.out.println("Categoria retornada "+categoriaRetornada);


        categoria.setCategoria("Frutos do Mar");
        categoriaDao.atualisar(categoria);
        entityManager.flush();

        System.out.println("Categoria depois de atualisada "+categoria);


        categoriaDao.excluir(categoria);
        entityManager.flush();

        Categoria categoriaRetornada2 = categoriaDao.consultar(1);
        System.out.println("-------Tentativa de recuperar categoria excluida : -------");
        System.out.println(categoriaRetornada2.getCategoria());

        entityManager.clear();


    }

}
