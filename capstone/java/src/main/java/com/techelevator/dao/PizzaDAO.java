package com.techelevator.dao;

import com.techelevator.model.process.Pizza;

import java.util.List;

public interface PizzaDAO {
    public List<Pizza> getSpecialtyPizzas();

//    TODO get pizza by id

    public Pizza createPizza(Pizza pizza);
}
