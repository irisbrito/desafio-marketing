package com.br.zup.marketing.dtos.categoria;

import com.br.zup.marketing.entities.Categoria;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class CadastroCategoriaDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "{validacao.categoria}")
    private String nome;

    public CadastroCategoriaDTO() {
    }

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

    public Categoria converterDTOParaModel(){
        Categoria categoria = new Categoria();
        categoria.setId(this.id);
        categoria.setNome(this.nome);

        return categoria;
    }
}
