package com.br.zup.marketing.services;

import com.br.zup.marketing.entities.Produto;
import com.br.zup.marketing.exceptions.ProdutoNaoEncontradoException;
import com.br.zup.marketing.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Produto pesquisarProdutoPeloNome(String nome){
        Optional<Produto> optionalProduto = produtoRepository.findByNome(nome);

        if (optionalProduto.isPresent()) {
            return optionalProduto.get();
        }

        throw new ProdutoNaoEncontradoException("Produto não existe");
    }

}
