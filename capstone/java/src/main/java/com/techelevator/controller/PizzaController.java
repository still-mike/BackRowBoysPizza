package com.techelevator.controller;

import com.techelevator.dao.Pizza.PizzaDAO;
import com.techelevator.model.process.Board;
import com.techelevator.model.process.Pizza;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
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

    @GetMapping("/pizzas/{id}")
    public Pizza getPizza(@PathVariable long id) throws InterruptedException {
        Thread.sleep(1000); //Simulated loading time

        Pizza result = dao.getPizza(id);
        if (result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Yo! I got no pie with number.");
        } else {
            return result;
        }
    }

    @DeleteMapping("/pizzas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePizza(@PathVariable long id) {
        if (!dao.deletePizza(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Yo! That pie is already gone. I can't find it.");
        }
    }

    //todo - add GET, UPDATE and ADD Ingredient endpoints

    //todo order endpoints

    //todo board endpoints

    @GetMapping("/boards")
    public List<Board> getBoards() throws InterruptedException {
        Thread.sleep( 1000);
        return dao.getAllBoards();
    }


}
