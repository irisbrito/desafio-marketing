package com.br.zup.marketing.services;

import com.br.zup.marketing.entities.Categoria;
import com.br.zup.marketing.entities.Cliente;
import com.br.zup.marketing.entities.Produto;
import com.br.zup.marketing.exceptions.ClienteNaoEncontradoException;
import com.br.zup.marketing.exceptions.ProdutoNaoEncontradoException;
import com.br.zup.marketing.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoService produtoService;

    List<Produto> produtos = new ArrayList<>();

    public Cliente cadastrarCliente(Cliente cliente){
        Cliente clienteEntity = null;

        try{
            clienteEntity = pesquisarClientePeloEmail(cliente.getEmail());
        }catch (Exception erro) {
            System.out.println("Cliente não encontrado, cadastrando cliente");
        }

        if(clienteEntity != null){
            produtos = clienteEntity.getProdutos();
        }

        buscarProdutosDoCliente(produtos);
        adicionarProdutosNaListaDoCliente(cliente);

        cliente.setProdutos(produtos);

        if(clienteEntity != null){
            cliente.setId(clienteEntity.getId());
        }

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

    public Iterable<Cliente> listarClientesPeloNomeDoProduto(String nome) {
        return clienteRepository.findAllByProdutosNome(nome);
    }

    public Iterable<Cliente> listarClientesPelaCategoriaDoProduto(String nome){
        return clienteRepository.findAllByProdutosCategoriasNome(nome);
    }

    public Cliente atualizarCliente(Cliente cliente){
        if(clienteRepository.existsById(cliente.getId())){
            Cliente objCliente = cadastrarCliente(cliente);
            return cliente;
        }
        throw new ClienteNaoEncontradoException("Cliente não encontrado");
    }

    public Cliente pesquisarClientePeloEmail(String email){
        Optional<Cliente> opitionalCliente = clienteRepository.findByEmail(email);

        if (opitionalCliente.isPresent()) {
            return opitionalCliente.get();
        }

        throw new ClienteNaoEncontradoException("Cliente não existe");
    }

    public List<Produto> buscarProdutosDoCliente(List<Produto> produtos){
        List<Produto> produtosDoCliente = new ArrayList<>();

        for(Produto produto : produtos){
            produtosDoCliente.add(produtoService.pesquisarProdutoPeloNome(produto.getNome()));
        }

        return produtosDoCliente;
    }

    public List<Produto> adicionarProdutosNaListaDoCliente(Cliente cliente){
        List<Produto> produtosDoCliente = new ArrayList<>();

        for(Produto produto : cliente.getProdutos()){
            if(!produtosDoCliente.contains(produto.getNome())){
                Produto produtoEntity = produtoService.pesquisarProdutoPeloNome(produto.getNome());
                produtos.add(produtoEntity);
            }
        }

        return produtos;
    }


}
