package br.com.guiromao.restaurante.dao;

import br.com.guiromao.restaurante.model.Produto;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProdutoDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Produto> lista() {
        String jpql = "select p from Produto p";
        return this.entityManager.createQuery(jpql, Produto.class).getResultList();
    }

    public void cadastra(Produto produto) {
        this.entityManager.persist(produto);
    }
}
