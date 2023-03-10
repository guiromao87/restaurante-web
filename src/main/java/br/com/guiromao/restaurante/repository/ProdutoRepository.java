package br.com.guiromao.restaurante.repository;

import br.com.guiromao.restaurante.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
