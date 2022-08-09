package com.techelevator.controller;

import com.techelevator.dao.ProcessDao;
import com.techelevator.model.process.Pizza;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProcessController {

    private ProcessDao dao;
    private JdbcTemplate jdbcTemplate;

    public ProcessController(ProcessDao processDao) {
        this.dao = processDao;
    }

    @GetMapping("/pizzas/specialty")
    public List<Pizza> getSpecialtyPizzas() {
        return dao.getSpecialtyPizzas();
    }

    @PostMapping("/pizzas/specialty")
    @ResponseStatus(HttpStatus.CREATED)
    public Pizza createSpecialtyPizza(@RequestBody Pizza newSpecialtyPizza) {
        return dao.createSpecialtyPizza(newSpecialtyPizza);
    }
}
