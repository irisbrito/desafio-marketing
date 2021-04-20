package com.br.zup.marketing.dtos;

import com.br.zup.marketing.entities.Cliente;
import com.br.zup.marketing.entities.Produto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;


public class CadastroClienteDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Email(message = "Email inválido")
    private String email;
    @NotNull(message = "Nome completo é obrigatório")
    private String nomeCompleto;
    @NotNull(message = "O telefone é obrigatório")
    private String telefone;
    private List<Produto> produtos;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente converterDTOParaModel(){
        Cliente cliente = new Cliente();
        cliente.setId(this.id);
        cliente.setEmail(this.email);
        cliente.setNomeCompleto(this.nomeCompleto);
        cliente.setTelefone(this.telefone);
        cliente.setProdutos(this.produtos);

        return cliente;
    }
}
