package br.com.guiromao.restaurante.repository;

import br.com.guiromao.restaurante.model.Endereco;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface EnderecoRepository extends Repository<Endereco, Integer> {
    void save(Endereco endereo);

    Optional<Endereco> findById(Integer id);
}
