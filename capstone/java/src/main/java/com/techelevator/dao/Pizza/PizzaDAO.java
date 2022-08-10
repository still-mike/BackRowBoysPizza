package com.techelevator.dao.Pizza;

import com.techelevator.model.process.Pizza;

import java.util.List;

public interface PizzaDAO {
    public List<Pizza> getSpecialtyPizzas();

    public Pizza getPizza(long pizzaId);

    public Pizza createPizza(Pizza pizza);

    public boolean updatePizza(Pizza pizza);

    public boolean deletePizza(long pizzaID);
}
