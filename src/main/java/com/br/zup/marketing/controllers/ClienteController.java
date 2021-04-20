package com.br.zup.marketing.controllers;

import com.br.zup.marketing.dtos.CadastroClienteDTO;
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
}
