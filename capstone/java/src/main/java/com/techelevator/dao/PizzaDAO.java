package com.techelevator.dao;

import com.techelevator.model.process.Pizza;

import java.util.List;

public interface PizzaDAO {
    public List<Pizza> getSpecialtyPizzas();

    public Pizza getPizza(long pizzaId);

    public Pizza createPizza(Pizza pizza);

//    TODO - will we ever need to update a pizza?

    public boolean deletePizza(long pizzaID);
}
