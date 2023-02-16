package br.com.guiromao.restaurante.model.dto;

import br.com.guiromao.restaurante.model.Categoria;
import br.com.guiromao.restaurante.model.Produto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProdutoFormInputDto {
    private Integer id;
    @NotBlank(message = "O campo nome deve ser preenchido")
    private String nome;
    @NotBlank(message = "O campo descrição deve ser preenchido")
    private String descricao;
    private Categoria categoria;
    @NotNull(message = "O campo preço deve ser preenchido")
    @Min(message = "O preço deve ser maior que 5", value = 5)
    private BigDecimal preco;

    public ProdutoFormInputDto(Integer id, String nome, String descricao, Categoria categoria, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Produto toProduto() {
        return new Produto(this.id, this.nome, this.descricao, this.categoria, this.preco);
    }
}
