package com.br.zup.marketing.services;

import com.br.zup.marketing.entities.Cliente;
import com.br.zup.marketing.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void deletarCliente(int id){
        clienteRepository.deleteById(id);
    }

}
