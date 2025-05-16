package com.mateus.lima.design_patterns_spring.useCases;

import com.mateus.lima.design_patterns_spring.models.ClienteEntity;
import com.mateus.lima.design_patterns_spring.useCases.interfaces.ClienteInterface;
import org.springframework.stereotype.Service;

@Service
public class ClienteUseCase implements ClienteInterface {


    @Override
    public Iterable<ClienteEntity> buscarTodos() {
        return null;
    }

    @Override
    public ClienteEntity buscarPorId(Long id) {
        return null;
    }

    @Override
    public void inserir(ClienteEntity cliente) {

    }

    @Override
    public void atualizar(Long id, ClienteEntity cliente) {

    }

    @Override
    public void deletar(Long id) {

    }
}
