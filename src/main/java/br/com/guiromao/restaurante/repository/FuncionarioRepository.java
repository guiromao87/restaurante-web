package br.com.guiromao.restaurante.repository;

import br.com.guiromao.restaurante.model.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query(
        value = "select * from funcionarios where nome = ? and email = ? and salario = ?",
        nativeQuery = true
    )
    List<Funcionario> findFuncionarios(String nome, String email, BigDecimal salario);
}
