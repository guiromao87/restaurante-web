package br.com.guiromao.restaurante.repository;

import br.com.guiromao.restaurante.model.Funcionario;
import br.com.guiromao.restaurante.model.projection.FuncionarioProjection;
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

    @Query(value = "select f.nome, f.salario, c.nome as cargo  from funcionarios f inner join cargos c  on f.cargo_id = c.id", nativeQuery = true)
    List<FuncionarioProjection> findFuncionario();
}
