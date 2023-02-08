package br.com.guiromao.restaurante.controller;

import br.com.guiromao.restaurante.model.Categoria;
import br.com.guiromao.restaurante.model.Produto;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String home() {

        Produto produto = new Produto();
        produto.setId(1);
        produto.setNome("Salada");
        produto.setDescricao("Salada de alface e tomate");
        produto.setCategoria(Categoria.COMIDA);
        produto.setPreco(new BigDecimal(35));

        return "home";
    }
}
