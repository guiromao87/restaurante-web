package br.com.guiromao.restaurante.controller;

import br.com.guiromao.restaurante.dao.ProdutoDao;
import br.com.guiromao.restaurante.model.Carrinho;
import br.com.guiromao.restaurante.model.ItemDeCompra;
import br.com.guiromao.restaurante.model.Produto;
import br.com.guiromao.restaurante.model.dto.ProdutoDetalheOutputDto;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.JSqlParserUtils;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private ProdutoDao produtoDao;

    @Autowired
    private Carrinho carrinho;

    @PostMapping("/add")
    public String add(Integer idProduto, Integer quantidade) {
        Produto produto = this.produtoDao.buscaPor(idProduto);
        ItemDeCompra itemDeCompra = new ItemDeCompra(produto, quantidade);
        this.carrinho.add(itemDeCompra);

        return "redirect:/produto/lista";
    }

    @GetMapping("/detalhe")
    public String detalhe(HttpSession session, Model model) {
        model.addAttribute("cliente", session.getAttribute("logado"));
        model.addAttribute("compras", this.carrinho.getCompras());
        model.addAttribute("total", this.carrinho.getTotal());

        return "carrinho/detalhe";
    }

    @GetMapping("/total")
    public void total() {
        this.carrinho.getCompras().forEach(compra -> System.out.println(compra));
    }

}
