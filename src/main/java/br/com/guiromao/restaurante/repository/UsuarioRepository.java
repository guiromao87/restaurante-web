package br.com.guiromao.restaurante.repository;

import br.com.guiromao.restaurante.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByLogin(String login);
}
