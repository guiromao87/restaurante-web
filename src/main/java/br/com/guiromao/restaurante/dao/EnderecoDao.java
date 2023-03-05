package br.com.guiromao.restaurante.dao;

import br.com.guiromao.restaurante.model.Cliente;
import br.com.guiromao.restaurante.model.Endereco;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EnderecoDao {

    @PersistenceContext
    private EntityManager em;

    public void cadastra(Endereco endereco) { this.em.persist(endereco); }

    public Endereco buscaPor(Integer id) { return this.em.find(Endereco.class, id); }

}
