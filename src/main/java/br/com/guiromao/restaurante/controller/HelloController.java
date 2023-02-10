package br.com.guiromao.restaurante.controller;

import br.com.guiromao.restaurante.model.ProdutoSimples;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model) {

        model.addAttribute("produtos",
                Arrays.asList(
                        new ProdutoSimples(1, "Celular", BigDecimal.TEN),
                        new ProdutoSimples(2, null, new BigDecimal(20)),
                        new ProdutoSimples(3, "Video Game", BigDecimal.ONE))
                );

        return "hello";
    }

}
