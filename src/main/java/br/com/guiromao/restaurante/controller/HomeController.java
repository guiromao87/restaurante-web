package br.com.guiromao.restaurante.controller;

import br.com.guiromao.restaurante.model.Produto;
import br.com.guiromao.restaurante.model.dto.ProdutoOutputDto;
import br.com.guiromao.restaurante.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("produtos",
                this.produtoRepository.findAll().stream().map(produto -> new ProdutoOutputDto(produto)).toList());
        return "home";
    }
}













