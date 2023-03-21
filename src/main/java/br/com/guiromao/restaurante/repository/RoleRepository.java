package br.com.guiromao.restaurante.repository;

import br.com.guiromao.restaurante.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
