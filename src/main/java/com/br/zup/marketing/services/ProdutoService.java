package com.br.zup.marketing.services;

import com.br.zup.marketing.entities.Categoria;
import com.br.zup.marketing.entities.Produto;
import com.br.zup.marketing.exceptions.ProdutoNaoEncontradoException;
import com.br.zup.marketing.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaService categoriaService;

    List<Categoria> categorias = new ArrayList<>();

    public Produto cadastrarProduto(Produto produto){
        Produto produtoEntity = null;

        try{
            produtoEntity = pesquisarProdutoPeloNome(produto.getNome());
        }catch (Exception erro) {
            System.out.println("Produto não encontrado, cadastrando produto");
        }

        if(produtoEntity != null){
            categorias = produtoEntity.getCategorias();
        }

        verificarCategoriasParaAdicionarNoProduto(produto);

        produto.setCategorias(categorias);

        if(produtoEntity != null){
            produto.setId(produtoEntity.getId());
        }

        return produtoRepository.save(produto);
    }


    public Produto verificarCategoriasParaAdicionarNoProduto(Produto produto){
        List<String> categoriasCadastradas = new ArrayList<>();

        for(Categoria categoriaEntity : categorias){
            categoriasCadastradas.add(categoriaEntity.getNome());
        }

        for(Categoria categoria : produto.getCategorias()) {
            if(!categoriasCadastradas.contains(categoria.getNome())){
                Categoria categoriaEntity = categoriaService.buscarCategoriaPeloNome(categoria.getNome());
                categorias.add(categoriaEntity);
            }
        }

        return produto;
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
