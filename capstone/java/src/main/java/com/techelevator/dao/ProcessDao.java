package com.techelevator.dao;

import com.techelevator.model.process.Pizza;

import java.util.List;

public interface ProcessDao {
    List<Pizza> getSpecialtyPizzas();

    Pizza createSpecialtyPizza(Pizza newSpecialtyPizza);
}
