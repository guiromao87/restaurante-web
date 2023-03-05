package br.com.guiromao.restaurante.controller;

import br.com.guiromao.restaurante.dao.EnderecoDao;
import br.com.guiromao.restaurante.dao.ProdutoDao;
import br.com.guiromao.restaurante.model.Carrinho;
import br.com.guiromao.restaurante.model.Cliente;
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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private ProdutoDao produtoDao;

    @Autowired
    private EnderecoDao enderecoDao;

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

    @GetMapping("/remove")
    public String remove(Integer id, Integer quantidade) {
        Produto produto = this.produtoDao.buscaPor(id);
        this.carrinho.remove(produto, quantidade);

        return "redirect:/carrinho/detalhe";
    }

    @PostMapping("/finaliza")
    public String finaliza(HttpSession session, @RequestParam("endereco") Integer id, Model model) {
        Cliente cliente = (Cliente) session.getAttribute("logado");

        model.addAttribute("cliente", cliente);
        model.addAttribute("compras", this.carrinho.getCompras());
        model.addAttribute("endereco", enderecoDao.buscaPor(id));

        return "carrinho/finaliza";
    }

}
