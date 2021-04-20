package com.br.zup.marketing.services;

import com.br.zup.marketing.entities.Categoria;
import com.br.zup.marketing.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria cadastrarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Iterable<Categoria> retornarCategorias(){
        return categoriaRepository.findAll();
    }
}
