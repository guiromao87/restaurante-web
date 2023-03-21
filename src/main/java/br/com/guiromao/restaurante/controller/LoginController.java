package br.com.guiromao.restaurante.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String form(@AuthenticationPrincipal User user) {
        if(user != null)
            return "redirect:/produto/lista";
        return "login/form";
    }

    @GetMapping("/negado")
    public String negado() { return "login/erro403"; }
}
