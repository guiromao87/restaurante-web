package br.com.guiromao.restaurante.controller;

import br.com.guiromao.restaurante.model.Funcionario;
import br.com.guiromao.restaurante.model.dto.FuncionarioAlteraInputDto;
import br.com.guiromao.restaurante.model.dto.FuncionarioInputDto;
import br.com.guiromao.restaurante.model.dto.FuncionarioOutputDto;
import br.com.guiromao.restaurante.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioDao;

    // localhost:8080/funcionarios - POST
    @Transactional
    @PostMapping
    public ResponseEntity cadastra(@RequestBody FuncionarioInputDto dto) {
        Funcionario funcionario = dto.toFuncionario();
        funcionarioDao.save(funcionario);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    // localhost:8080/funcionarios - GET
    @GetMapping
    public List<FuncionarioOutputDto> lista() {
        List<Funcionario> funcionarios = this.funcionarioDao.findAll();
        List<FuncionarioOutputDto> funcionarioOutputDtoList =  funcionarios.stream().map(funcionario -> new FuncionarioOutputDto(funcionario)).toList();

        return funcionarioOutputDtoList;
    }

    // localhost:8080/funcionarios/id - GET
    @GetMapping("/{id}")
    public FuncionarioOutputDto buscaPor(@PathVariable Integer id) {
        List<Funcionario> funcionarios = this.funcionarioDao.findFuncionarios("Rita", "rita@gmail.com", new BigDecimal(2000.00));
        System.out.println(funcionarios.get(0).getNome());


//        Funcionario funcionario = this.funcionarioDao.findById(id).get();
//        FuncionarioOutputDto dto = new FuncionarioOutputDto(funcionario);

        return null;
    }
    
    @Transactional
    @DeleteMapping("/{id}")
    public void deleta(@PathVariable Integer id) {
        this.funcionarioDao.deleteById(id);
    }

    // localhost:8080/funcionarios - PUT
    @Transactional
    @PutMapping
    public void altera(@RequestBody FuncionarioAlteraInputDto dto) {
        Funcionario funcionario = this.funcionarioDao.findById(dto.getId()).get();
        funcionario.setEmail(dto.getEmail());
        funcionario.setSalario(dto.getSalario());
    }


}