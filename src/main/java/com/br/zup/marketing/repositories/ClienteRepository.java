package com.br.zup.marketing.repositories;

import com.br.zup.marketing.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    Iterable<Cliente> findAllByProdutos_id(int id);
}
