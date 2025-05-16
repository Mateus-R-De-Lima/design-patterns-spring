package com.mateus.lima.design_patterns_spring.useCases;

import com.mateus.lima.design_patterns_spring.models.EnderecoEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "viacep",url = "https://viacep.com.br/ws")
public interface ViaCepUseCase {
    @GetMapping("/{cep}/json/")
    EnderecoEntity consultarCep(@PathVariable("cep") String cep);
}
