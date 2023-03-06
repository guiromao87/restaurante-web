package br.com.guiromao.restaurante.controller;

import br.com.guiromao.restaurante.dao.FuncionarioDao;
import br.com.guiromao.restaurante.model.Funcionario;
import br.com.guiromao.restaurante.model.dto.FuncionarioAlteraInputDto;
import br.com.guiromao.restaurante.model.dto.FuncionarioInputDto;
import br.com.guiromao.restaurante.model.dto.FuncionarioOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioDao funcionarioDao;

    // localhost:8080/funcionarios - POST
    @Transactional
    @PostMapping
    public ResponseEntity cadastra(@RequestBody FuncionarioInputDto dto) {
        Funcionario funcionario = dto.toFuncionario();
        funcionarioDao.cadastra(funcionario);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    // localhost:8080/funcionarios - GET
    @GetMapping
    public List<FuncionarioOutputDto> lista() {
        List<Funcionario> funcionarios = this.funcionarioDao.lista();
        List<FuncionarioOutputDto> funcionarioOutputDtoList =  funcionarios.stream().map(funcionario -> new FuncionarioOutputDto(funcionario)).toList();

        return funcionarioOutputDtoList;
    }

    // localhost:8080/funcionarios/id - GET
    @GetMapping("/{id}")
    public FuncionarioOutputDto buscaPor(@PathVariable Integer id) {
        Funcionario funcionario = this.funcionarioDao.buscaPor(id);
        FuncionarioOutputDto dto = new FuncionarioOutputDto(funcionario);

        return dto;
    }
    
    @Transactional
    @DeleteMapping("/{id}")
    public void deleta(@PathVariable Integer id) {
        this.funcionarioDao.remove(id);
    }

    // localhost:8080/funcionarios - PUT
    @Transactional
    @PutMapping
    public void altera(@RequestBody FuncionarioAlteraInputDto dto) {
        Funcionario funcionario = this.funcionarioDao.buscaPor(dto.getId());
        funcionario.setEmail(dto.getEmail());
        funcionario.setSalario(dto.getSalario());
    }


}