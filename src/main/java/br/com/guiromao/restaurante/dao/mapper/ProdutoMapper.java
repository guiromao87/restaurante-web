package br.com.guiromao.restaurante.dao.mapper;

import br.com.guiromao.restaurante.model.Categoria;
import br.com.guiromao.restaurante.model.Produto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoMapper implements RowMapper<Produto> {
    @Override
    public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Produto(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("descricao"),
                Categoria.valueOf(rs.getString("categoria").toUpperCase()),
                rs.getBigDecimal("preco")
        );
    }
}
