package com.mateus.lima.design_patterns_spring.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @ManyToOne
    private EnderecoEntity endereco;


}
