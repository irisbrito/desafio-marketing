package com.br.zup.marketing.dtos.produto;

import com.br.zup.marketing.entities.Categoria;
import com.br.zup.marketing.entities.Produto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CadastroProdutoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Nome do produto é obrigatório")
    private String nome;
    @NotNull(message = "Deve incluir ao menos uma categoria")
    private List<Categoria> categorias;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Produto converterDTOParaModel(){
        Produto produto = new Produto();
        produto.setId(this.id);
        produto.setNome(this.nome);
        produto.setCategorias(this.categorias);

        return produto;
    }
}
