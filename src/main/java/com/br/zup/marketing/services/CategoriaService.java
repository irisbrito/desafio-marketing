package com.br.zup.marketing.services;

import com.br.zup.marketing.entities.Categoria;
import com.br.zup.marketing.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Categoria buscarCategoriaPeloNome(String nome){
        Optional<Categoria> categoria = categoriaRepository.findByNome(nome);
        if(categoria.isPresent()){
            return categoria.get();
        }
       throw new RuntimeException("Categoria não encontrada");
    }

    public void deletarCategoria(int id){
        categoriaRepository.deleteById(id);
    }
}
