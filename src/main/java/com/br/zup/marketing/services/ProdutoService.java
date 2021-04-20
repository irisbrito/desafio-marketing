package com.br.zup.marketing.services;

import com.br.zup.marketing.entities.Produto;
import com.br.zup.marketing.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastrarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public Iterable<Produto> buscarProdutos(){
        return produtoRepository.findAll();
    }

}
