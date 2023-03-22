package br.com.guiromao.restaurante.controller;

import br.com.guiromao.restaurante.model.Endereco;
import br.com.guiromao.restaurante.model.Role;
import br.com.guiromao.restaurante.model.Usuario;
import br.com.guiromao.restaurante.model.dto.UsuarioInputDto;
import br.com.guiromao.restaurante.model.dto.UsuarioOutputDto;
import br.com.guiromao.restaurante.repository.EnderecoRepository;
import br.com.guiromao.restaurante.repository.RoleRepository;
import br.com.guiromao.restaurante.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/lista")
    public String lista(Model model) {
        model.addAttribute("usuarios",
                usuarioRepository.findAll().stream().map(usuario -> new UsuarioOutputDto(usuario)).toList());

        return "usuario/lista";
    }

    @GetMapping("/form")
    public String form(Model model) {
        List<Role> roles = this.roleRepository.findAll();
        model.addAttribute("roles", roles);
        return "usuario/form";
    }

    @PostMapping("/cadastra")
    public String cadastra(UsuarioInputDto usuarioInputDto) {

        List<Role> roles = usuarioInputDto.getRoleIds().stream().map(id -> new Role(id)).toList();

        Usuario usuario = usuarioInputDto.toUsuario();
        usuario.setRoles(roles);
        this.usuarioRepository.save(usuario);

        Endereco endereco = usuarioInputDto.toEndereco();
        endereco.setUsuario(usuario);
        this.enderecoRepository.save(endereco);

        return "redirect:/usuario/lista";
    }










}
