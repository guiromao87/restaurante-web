package br.com.guiromao.restaurante.controller;

import br.com.guiromao.restaurante.dao.ProdutoDao;
import br.com.guiromao.restaurante.model.Categoria;
import br.com.guiromao.restaurante.model.Produto;
import br.com.guiromao.restaurante.model.dto.ProdutoFormInputDto;
import br.com.guiromao.restaurante.model.dto.ProdutoOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoDao dao;

    @GetMapping("/lista")
    public String lista(Model model) {
        List<ProdutoOutputDto> produtosDto = dao.lista().stream().map(produto -> new ProdutoOutputDto(produto)).collect(Collectors.toList());
        model.addAttribute("produtos", produtosDto);
        return "produtos";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("categorias", Categoria.values());
        return "form";
    }

    @PostMapping("/cadastra")
    public String cadastra(ProdutoFormInputDto produtoFormInputDto, RedirectAttributes redirectAttributes) {
        Produto produto = produtoFormInputDto.toProduto();
        this.dao.cadastra(produto);
        redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
        return "redirect:/produto/lista";
    }
}

// DTO - DATA TRANSFER OBJ
// Classe de infraestrutura(recebe request e response) -> Modelos
// Produto -> Objeto de domínio, objetos de dominio devem ser PROTEGIDOS





