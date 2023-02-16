package br.com.guiromao.restaurante.dao;

import br.com.guiromao.restaurante.dao.mapper.ProdutoMapper;
import br.com.guiromao.restaurante.model.Categoria;
import br.com.guiromao.restaurante.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Produto> lista() {
        return this.jdbcTemplate.query("select * from produtos" , new ProdutoMapper());
    }

    public void cadastra(Produto produto) {
        this.jdbcTemplate.update(
                "insert into produtos (nome,descricao,categoria,preco) values (?,?,?,?)",
                produto.getNome(),
                produto.getDescricao(),
                produto.getCategoria().getDescricao(),
                produto.getPreco()
        );
    }




}
