package br.com.guiromao.restaurante.controller;

import br.com.guiromao.restaurante.dao.ClienteDao;
import br.com.guiromao.restaurante.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private ClienteDao clienteDao;

    @GetMapping
    public String form() {
        return "login/form";
    }

    @PostMapping("/login")
    public String login(String email, String senha) {
        Cliente cliente = this.clienteDao.existe(email, senha);
        System.out.println(cliente);

        return "redirect:/produto/lista";
    }
}
