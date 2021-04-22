package com.br.zup.marketing.repositories;

import com.br.zup.marketing.entities.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
    Optional<Categoria> findByNome(String nome);
}
