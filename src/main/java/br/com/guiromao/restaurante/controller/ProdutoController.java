package br.com.guiromao.restaurante.controller;

import br.com.guiromao.restaurante.dao.ProdutoDao;
import br.com.guiromao.restaurante.model.Categoria;
import br.com.guiromao.restaurante.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoDao dao;

    @GetMapping("/lista")
    public String lista(Model model) {
        model.addAttribute("produtos", dao.lista());
        return "produtos";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("categorias", Categoria.values());
        return "form";
    }

    @PostMapping("/cadastra")
    public String cadastra(Produto produto, RedirectAttributes redirectAttributes) {
        this.dao.cadastra(produto);
        redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
        return "redirect:/produto/lista";
    }
}





