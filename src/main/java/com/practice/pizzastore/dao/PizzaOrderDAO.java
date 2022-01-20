package com.practice.pizzastore.dao;

import com.practice.pizzastore.entity.PizzaOrderEntity;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

@RepositoryDefinition(idClass = Integer.class, domainClass = PizzaOrderEntity.class)
@Transactional(value = "txManager")
public interface PizzaOrderDAO {
    PizzaOrderEntity save(PizzaOrderEntity entity);
}
