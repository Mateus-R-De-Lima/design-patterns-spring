package com.mateus.lima.design_patterns_spring.repositories;

import com.mateus.lima.design_patterns_spring.models.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity,Long>{
}
