package com.mateus.lima.design_patterns_spring.useCases.interfaces;

import com.mateus.lima.design_patterns_spring.models.ClienteEntity;

public interface ClienteInterface {
    Iterable<ClienteEntity> buscarTodos();
    ClienteEntity buscarPorId(Long id);
    void inserir (ClienteEntity cliente);
    void atualizar(Long id, ClienteEntity cliente);
    void deletar(Long id);
}
