package com.br.zup.marketing.controllers;

import com.br.zup.marketing.dtos.categoria.CadastroCategoriaDTO;
import com.br.zup.marketing.entities.Categoria;
import com.br.zup.marketing.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categorias/")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria cadastrarCategoria(@RequestBody CadastroCategoriaDTO categoriaDTO){
        Categoria categoria = categoriaService.cadastrarCategoria(categoriaDTO.converterDTOParaModel());
        return categoria;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Categoria> buscarCategorias(){
        return categoriaService.retornarCategorias();
    }
}
