package com.techelevator.controller;

import com.techelevator.dao.Pizza.PizzaDAO;
import com.techelevator.model.process.Board;
import com.techelevator.model.process.Ingredient;
import com.techelevator.model.process.Order;
import com.techelevator.model.process.Pizza;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class PizzaController {

    private PizzaDAO dao;

    public PizzaController(PizzaDAO pizzaDAO) {
        this.dao = pizzaDAO;
    }

    @GetMapping("/pizzas")
    public List<Pizza> getAllPizzas() {
        return dao.getAllPizzas();
    }

    @GetMapping("/pizzas/specialty")
    public List<Pizza> getSpecialtyPizzas() {
        return dao.getSpecialtyPizzas();
    }

    @PostMapping("/pizzas")
    @ResponseStatus(HttpStatus.CREATED)
    public Pizza employeeCreatePizza(@RequestBody Pizza pizza) {
        return dao.employeeCreatePizza(pizza);
    }

    @PutMapping("/pizzas/{id}")
    public Pizza putPizza(@PathVariable long id, @RequestBody Pizza updatedPizza){
        updatedPizza.setId(id);
        if(dao.updatePizza(updatedPizza)){
            return updatedPizza;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Get outahere! That Pizza was never made!");
        }
    }

    @GetMapping("/pizzas/{id}")
    public Pizza getPizza(@PathVariable long id) throws InterruptedException {
        Thread.sleep(1000); //Simulated loading time

        Pizza result = dao.getPizza(id);
        if (result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Yo! I got no pie with that number.");
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

   @GetMapping("/ing")
    public List<Ingredient> getIngredientsList(){
        return dao.getAllIngredients();
    }


    // Todo - UPDATE and ADD pizza_ingredient endpoints

    //order endpoints
    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable long id) throws InterruptedException {
        Thread.sleep(1000); //Simulated loading time

        Order result = dao.getOrder(id);
        if (result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Yo! That order doesn't exist.");
        } else {
            return result;
        }
    }

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody Order order, Pizza pizza) {
        return dao.createOrder(order, pizza);
    }

    //board endpoints
    @GetMapping("/boards")
    public List<Board> getBoards() throws InterruptedException {
        Thread.sleep( 1000);
        return dao.getAllBoards();
    }

    @GetMapping("/boards/{id}")
    public Board getBoard(@PathVariable long id) throws InterruptedException {
        Thread.sleep(1000); //Simulated loading time

        Board result = dao.getBoard(id);
        if (result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No board with that id.");
        } else {
            return result;
        }
    }


}
