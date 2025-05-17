package com.mateus.lima.design_patterns_spring.useCases;

import com.mateus.lima.design_patterns_spring.models.ClienteEntity;
import com.mateus.lima.design_patterns_spring.models.EnderecoEntity;
import com.mateus.lima.design_patterns_spring.repositories.ClienteRepository;
import com.mateus.lima.design_patterns_spring.repositories.EnderecoRepository;
import com.mateus.lima.design_patterns_spring.useCases.interfaces.ClienteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteUseCase implements ClienteInterface {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private  ViaCepUseCase viaCepUseCase;

    @Override
    public Iterable<ClienteEntity> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteEntity buscarPorId(Long id) {
        Optional<ClienteEntity> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(ClienteEntity cliente) {
        cadastraClienteComCep(cliente);

    }

    @Override
    public void atualizar(Long id, ClienteEntity cliente) {

        Optional<ClienteEntity> clienteCadastrado = clienteRepository.findById(id);
        if(clienteCadastrado.isPresent()){
            cadastraClienteComCep(cliente);
        }

    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void cadastraClienteComCep(ClienteEntity cliente){
        String cep = cliente.getEndereco().getCep();
        EnderecoEntity endereco = enderecoRepository.findById(cep).orElseGet(() ->{
            EnderecoEntity novoEndereco = viaCepUseCase.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
