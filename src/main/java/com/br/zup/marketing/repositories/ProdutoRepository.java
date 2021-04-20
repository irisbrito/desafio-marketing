package com.br.zup.marketing.repositories;

import com.br.zup.marketing.entities.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}
