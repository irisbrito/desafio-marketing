package com.br.zup.marketing.dtos.cliente;

import com.br.zup.marketing.entities.Cliente;
import com.br.zup.marketing.entities.Produto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

public class AtualizarClienteDTO {

    @Email(message = "{validacao.email_invalido}")
    private String email;
    @NotNull(message = "{validacao.nome_completo}")
    private String nomeCompleto;
    @NotNull(message = "{validacao.telefone}")
    private String telefone;
    @NotNull(message = "{validacao.produtos")
    private List<Produto> produtos;

    public AtualizarClienteDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente converterDTOParaModel(int id){
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setEmail(this.email);
        cliente.setProdutos(this.produtos);
        cliente.setTelefone(this.telefone);
        cliente.setNomeCompleto(this.nomeCompleto);

        return cliente;
    }
}
