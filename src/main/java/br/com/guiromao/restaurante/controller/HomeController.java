package br.com.guiromao.restaurante.controller;

import br.com.guiromao.restaurante.model.Categoria;
import br.com.guiromao.restaurante.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Arrays;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public ModelAndView home() {

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("produto", new Produto(
                1,
                "Salada",
                "Salada de Alface e tomate",
                Categoria.COMIDA,
                BigDecimal.TEN
        ));

        return modelAndView;
    }

    @GetMapping("/lista")
    public String lista(Model model) {
        Produto p1 = new Produto(1, "Salada", "Salada de Alface e tomate", Categoria.COMIDA, BigDecimal.TEN);
        Produto p2 = new Produto(2, "Frango grelhado", "Acompanha arros", Categoria.COMIDA, BigDecimal.ONE);
        Produto p3 = new Produto(3, "Refrigerante", "Aguá tonica sem açucar", Categoria.BEBIDA, BigDecimal.ZERO);

        model.addAttribute("produtos", Arrays.asList(p1, p2, p3));

        System.out.println(Arrays.asList(p1, p2, p3));

        return "produtos";
    }
}
