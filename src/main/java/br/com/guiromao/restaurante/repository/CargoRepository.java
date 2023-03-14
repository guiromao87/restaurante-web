package br.com.guiromao.restaurante.repository;

import br.com.guiromao.restaurante.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {
}
