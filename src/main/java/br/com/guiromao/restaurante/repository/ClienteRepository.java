package br.com.guiromao.restaurante.repository;

import br.com.guiromao.restaurante.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByEmailAndSenha(String email, String senha);
}
