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

    public Iterable<Cliente> buscarClientes(){
        return clienteRepository.findAll();
    }

    public Iterable<Cliente> listarClientesPeloIdDoProduto(int id) {
        return clienteRepository.findAllByProdutos_id(id);
    }

    public Iterable<Cliente> listarClientesPelaCategoriaDoProduto(int id){
        return clienteRepository.findAllByProdutos_categorias_id(id);
    }

    public Cliente atualizarCliente(Cliente cliente){
        if(clienteRepository.existsById(cliente.getId())){
            Cliente objCliente = cadastrarCliente(cliente);
            return cliente;
        }
        throw new RuntimeException("Cliente não encontrado");
    }

}
