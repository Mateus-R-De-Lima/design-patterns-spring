package com.mateus.lima.design_patterns_spring.controller;

import com.mateus.lima.design_patterns_spring.models.ClienteEntity;
import com.mateus.lima.design_patterns_spring.useCases.ClienteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteRestController {
    @Autowired
    private ClienteUseCase clienteUseCase;

    @GetMapping
    public ResponseEntity<Iterable<ClienteEntity>> buscarTodos(){
        return ResponseEntity.ok(clienteUseCase.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteUseCase.buscarPorId(id));
    }

    @PatchMapping
    public ResponseEntity<ClienteEntity> inserir(@RequestBody ClienteEntity clienteEntity){
        clienteUseCase.inserir(clienteEntity);
        return ResponseEntity.ok(clienteEntity);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ClienteEntity> atualizar(@PathVariable Long id, @RequestBody ClienteEntity clienteEntity){
        clienteUseCase.atualizar(id,clienteEntity);
        return ResponseEntity.ok(clienteEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        clienteUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
