package br.com.guiromao.restaurante.dao;

import br.com.guiromao.restaurante.model.Produto;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProdutoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Cacheable("produtos")
    public List<Produto> lista() {
        String jpql = "select p from Produto p";
        return this.entityManager.createQuery(jpql, Produto.class).getResultList();
    }

    @CacheEvict(value = "produtos", allEntries = true)
    public void cadastra(Produto produto) {
        this.entityManager.persist(produto);
    }

    public Produto buscaPor(Integer id) { return this.entityManager.find(Produto.class, id); }

    @CacheEvict(value = "produtos", allEntries = true)
    public void deleta(Integer id) {
        Produto produto = this.entityManager.find(Produto.class, id);
        this.entityManager.remove(produto);
    }
}
