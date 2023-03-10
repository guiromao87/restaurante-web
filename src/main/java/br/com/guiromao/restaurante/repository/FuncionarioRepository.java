package br.com.guiromao.restaurante.repository;

import br.com.guiromao.restaurante.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
