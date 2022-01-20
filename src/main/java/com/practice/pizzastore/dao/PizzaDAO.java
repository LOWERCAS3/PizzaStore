package com.practice.pizzastore.dao;

import java.util.List;

import com.practice.pizzastore.entity.PizzaEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

@RepositoryDefinition(idClass = Integer.class, domainClass = PizzaEntity.class)
@Transactional(value = "txManager")
public interface PizzaDAO {
    @Query(name = "PIZZA.query1_findAllPizzaDetails")
    List <PizzaEntity> findAllPizzaDetails();
}
