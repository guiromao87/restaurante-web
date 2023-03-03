package br.com.guiromao.restaurante.controller;

import br.com.guiromao.restaurante.dao.ClienteDao;
import br.com.guiromao.restaurante.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private ClienteDao clienteDao;

    @GetMapping
    public String form() {
        return "login/form";
    }

    @PostMapping("/login")
    public String login(String email, String senha, RedirectAttributes redirectAttributes, HttpSession session) {
        Cliente cliente = this.clienteDao.existe(email, senha);

        if(cliente == null) {
            redirectAttributes.addFlashAttribute("usuarioInvalido","Usuário inválido");
            return "redirect:/";
        }

        session.setAttribute("logado", cliente);

        return "redirect:/produto/lista";
    }
}