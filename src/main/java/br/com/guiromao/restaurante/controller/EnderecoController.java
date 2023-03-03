package br.com.guiromao.restaurante.controller;

import br.com.guiromao.restaurante.dao.ClienteDao;
import br.com.guiromao.restaurante.dao.EnderecoDao;
import br.com.guiromao.restaurante.model.Cliente;
import br.com.guiromao.restaurante.model.Endereco;
import br.com.guiromao.restaurante.model.dto.EnderecoInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private ClienteDao clienteDao;

    @Autowired
    private EnderecoDao enderecoDao;

    @GetMapping("/form")
    public String form(@RequestParam("id") Integer idCliente, Model model) {
        Cliente cliente = this.clienteDao.buscaPor(idCliente);
        model.addAttribute("cliente", cliente);
        return "endereco/form";
    }

    @Transactional
    @PostMapping("/cadastra")
    public String cadastra(EnderecoInputDto enderecoInputDto) {
        Cliente cliente = this.clienteDao.buscaPor(enderecoInputDto.getId());
        Endereco endereco = enderecoInputDto.toEndereco(cliente);

        this.enderecoDao.cadastra(endereco); // MANAGED
        cliente.adiciona(endereco);

        return "redirect:/cliente/lista";
    }













}
