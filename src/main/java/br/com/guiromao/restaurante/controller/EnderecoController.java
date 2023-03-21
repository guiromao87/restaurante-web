package br.com.guiromao.restaurante.controller;

import br.com.guiromao.restaurante.model.Endereco;
import br.com.guiromao.restaurante.model.dto.EnderecoInputDto;
import br.com.guiromao.restaurante.repository.EnderecoRepository;
import br.com.guiromao.restaurante.service.CepService;
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
    private EnderecoRepository enderecoDao;

    @Autowired
    private CepService cepService;

    @GetMapping("/formCep")
    public String formCep(@RequestParam("id") Integer idCliente, Model model) {
        model.addAttribute("idCliente", idCliente);
        return "endereco/formCep";
    }

    @GetMapping("/pesquisa")
    public String pesquisa(Integer id, String cep, Model model) {
//        model.addAttribute("cliente", this.clienteDao.findById(id).get());
        model.addAttribute("cep", cep);
        model.addAttribute("rua", this.cepService.getRua(cep));

        return "endereco/form";
    }


//    @Transactional
//    @PostMapping("/cadastra")
//    public String cadastra(EnderecoInputDto enderecoInputDto) {
//        Cliente cliente = this.clienteDao.findById(enderecoInputDto.getId()).get();
//        Endereco endereco = enderecoInputDto.toEndereco(cliente);
//
//        this.enderecoDao.save(endereco);
//        cliente.adiciona(endereco);
//
//        return "redirect:/cliente/lista";
//    }
}