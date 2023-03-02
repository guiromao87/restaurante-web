package br.com.guiromao.restaurante.model.dto;

import br.com.guiromao.restaurante.model.Categoria;

import java.math.BigDecimal;

public class ProdutoAlteraInputDto {
    private Integer id;
    private String nome;
    private String descricao;
    private Categoria categoria;
    private BigDecimal preco;

    public void setId(Integer id) {this.id = id;}

    public void setNome(String nome) {this.nome = nome;}

    public void setCategoria(Categoria categoria) {this.categoria = categoria;}

    public void setDescricao(String descricao) {this.descricao = descricao;}

    public void setPreco(BigDecimal preco) {this.preco = preco;}

    public Integer getId() {return id;}

    public String getNome() {return nome;}

    public String getDescricao() {return descricao;}

    public Categoria getCategoria() {return categoria;}

    public BigDecimal getPreco() {return preco;}
}
