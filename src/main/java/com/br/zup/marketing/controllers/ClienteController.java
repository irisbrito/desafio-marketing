package com.br.zup.marketing.controllers;

import com.br.zup.marketing.dtos.cliente.AtualizarClienteDTO;
import com.br.zup.marketing.dtos.cliente.CadastroClienteDTO;
import com.br.zup.marketing.entities.Cliente;
import com.br.zup.marketing.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("clientes/")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadastrarCliente(@RequestBody @Valid CadastroClienteDTO clienteDTO){
        Cliente cliente = clienteService.cadastrarCliente(clienteDTO.converterDTOParaModel());
        return cliente;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Cliente> buscarClientes(){
        return clienteService.buscarClientes();
    }

    @GetMapping("produto/{nome}/")
    public Iterable<Cliente> buscarClientesPeloNomeDoProduto(@PathVariable String nome){
        return clienteService.listarClientesPeloNomeDoProduto(nome);
    }

    @GetMapping("categoria/{nome}/")
    public Iterable<Cliente> buscarClientesPelaCategoriaDoProduto(@PathVariable String nome){
        return clienteService.listarClientesPelaCategoriaDoProduto(nome);
    }

    @PutMapping("{id}/")
    public Cliente atualizarCliente(@PathVariable int id, @RequestBody @Valid AtualizarClienteDTO clienteDTO){
        Cliente cliente = clienteService.atualizarCliente(clienteDTO.converterDTOParaModel(id));
        return cliente;
    }


    @DeleteMapping("{id}/")
    @ResponseStatus(HttpStatus.OK)
    public void deletarCliente(@PathVariable int id){
        clienteService.deletarCliente(id);
    }

}
