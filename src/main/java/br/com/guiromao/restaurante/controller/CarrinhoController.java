package br.com.guiromao.restaurante.controller;


import br.com.guiromao.restaurante.model.Carrinho;
import br.com.guiromao.restaurante.model.Cliente;
import br.com.guiromao.restaurante.model.ItemDeCompra;
import br.com.guiromao.restaurante.model.Produto;
import br.com.guiromao.restaurante.repository.EnderecoRepository;
import br.com.guiromao.restaurante.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private ProdutoRepository produtoDao;

    @Autowired
    private EnderecoRepository enderecoDao;

    @Autowired
    private Carrinho carrinho;

    @PostMapping("/add")
    public String add(Integer idProduto, Integer quantidade) {
        Produto produto = this.produtoDao.findById(idProduto).get();
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
        Produto produto = this.produtoDao.findById(id).get();
        this.carrinho.remove(produto, quantidade);

        return "redirect:/carrinho/detalhe";
    }

    @PostMapping("/finaliza")
    public String finaliza(HttpSession session, @RequestParam("endereco") Integer id, Model model) {
        Cliente cliente = (Cliente) session.getAttribute("logado");

        model.addAttribute("cliente", cliente);
        model.addAttribute("compras", this.carrinho.getCompras());
        model.addAttribute("endereco", enderecoDao.findById(id).get());

        return "carrinho/finaliza";
    }

}
