package com.techelevator.controller;

import com.techelevator.dao.Pizza.PizzaDAO;
import com.techelevator.model.process.Pizza;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PizzaController {

    private PizzaDAO dao;

    public PizzaController(PizzaDAO pizzaDAO) {
        this.dao = pizzaDAO;
    }

    @GetMapping("/pizzas/specialty")
    public List<Pizza> getSpecialtyPizzas() {
        return dao.getSpecialtyPizzas();
    }

    @PostMapping("/pizzas")
    @ResponseStatus(HttpStatus.CREATED)
    public Pizza createPizza(@RequestBody Pizza pizza) {
        return dao.createPizza(pizza);
    }

//  TODO getPizzaById

    @DeleteMapping("/pizzas/{id}")
    @ResponseStatus(H)
//  TODO deletePizza
}
