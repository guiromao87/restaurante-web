package br.com.guiromao.restaurante.controller;

import br.com.guiromao.restaurante.dao.ProdutoDao;
import br.com.guiromao.restaurante.model.Categoria;
import br.com.guiromao.restaurante.model.Produto;
import br.com.guiromao.restaurante.model.dto.ProdutoAlteraInputDto;
import br.com.guiromao.restaurante.model.dto.ProdutoDetalheOutputDto;
import br.com.guiromao.restaurante.model.dto.ProdutoFormInputDto;
import br.com.guiromao.restaurante.model.dto.ProdutoOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
    public String form(Model model, ProdutoFormInputDto produtoFormInputDto) {
        model.addAttribute("categorias", Categoria.values());
        model.addAttribute("produtoFormInputDto", produtoFormInputDto);
        return "form";
    }

    @Transactional
    @PostMapping("/cadastra")
    public String cadastra(@Valid ProdutoFormInputDto produtoFormInputDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if(bindingResult.hasErrors())
            return form(model, produtoFormInputDto);

        Produto produto = produtoFormInputDto.toProduto();
        this.dao.cadastra(produto);
        redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
        return "redirect:/produto/lista";
    }

    @GetMapping("/detalhe/{id}")
    public String detalhe(@PathVariable Integer id, Model model) {
        model.addAttribute("produto", new ProdutoDetalheOutputDto(this.dao.buscaPor(id)));
        return "detalhe";
    }

    @Transactional
    @GetMapping("/deleta")
    public String deleta(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        this.dao.deleta(id);
        redirectAttributes.addFlashAttribute("sucesso", "Produto deletado com sucesso!");
        return "redirect:/produto/lista";
    }

    @GetMapping("/preparaAltera")
    public String preparaAltera(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("produto", this.dao.buscaPor(id));
        model.addAttribute("categorias", Categoria.values());
        return "form-altera";
    }

    @Transactional
    @PostMapping("/atualiza")
    public String atualiza(ProdutoAlteraInputDto dto, RedirectAttributes redirectAttributes) {
        Produto produto = this.dao.buscaPor(dto.getId());
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setCategoria(dto.getCategoria());
        produto.setPreco(dto.getPreco());

        redirectAttributes.addFlashAttribute("sucesso", "Produto alterado com sucesso");
        return "redirect:/produto/lista";
    }
}





