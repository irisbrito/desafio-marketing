package com.br.zup.marketing.repositories;

import com.br.zup.marketing.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    Iterable<Cliente> findAllByProdutos_id(int id);
    Iterable<Cliente> findAllByProdutosNome(String nome);
    Iterable<Cliente> findAllByProdutos_categorias_id(int id);
    Iterable<Cliente> findAllByProdutosCategoriasNome(String nome);
    Iterable<Cliente> findByEmail(String email);
    boolean existsByEmail(String email);
}
