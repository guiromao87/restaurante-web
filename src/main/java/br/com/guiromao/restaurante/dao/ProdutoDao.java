package br.com.guiromao.restaurante.dao;

import br.com.guiromao.restaurante.model.Categoria;
import br.com.guiromao.restaurante.model.Produto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoDao {

    private static List<Produto> produtos = new ArrayList<>();

    public List<Produto> lista() {
        produtos.clear();
        produtos.add(new Produto(1, "Salada", "Salada de Alface e tomate", Categoria.COMIDA, BigDecimal.TEN));
        produtos.add(new Produto(2, "Frango grelhado", "Acompanha arroz", Categoria.COMIDA, BigDecimal.ONE));
        produtos.add(new Produto(3, "Refrigerante", "Aguá tonica sem açucar", Categoria.BEBIDA, BigDecimal.ZERO));
        produtos.add(new Produto(4, "Brigadeiro", "Brigadeiro de colher", Categoria.SOBREMESA, BigDecimal.ZERO));

        return produtos;
    }




}
