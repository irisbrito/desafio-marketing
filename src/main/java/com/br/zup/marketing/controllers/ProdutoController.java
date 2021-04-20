package com.br.zup.marketing.controllers;

import com.br.zup.marketing.dtos.produto.CadastroProdutoDTO;
import com.br.zup.marketing.entities.Produto;
import com.br.zup.marketing.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("produtos/")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastrarProduto(@RequestBody @Valid CadastroProdutoDTO produtoDTO){
        Produto produto  = produtoService.cadastrarProduto(produtoDTO.converterDTOParaModel());
        return produto;
    }
}
