package com.techelevator.controller;

import com.techelevator.dao.ProcessDao;
import com.techelevator.model.process.Pizza;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ProcessController {

    private ProcessDao dao;
    private JdbcTemplate jdbcTemplate;

    public ProcessController(ProcessDao processDao) {
        this.dao = processDao;
    }

    @GetMapping("/pizzas")
    public List<Pizza> getSpecialtyPizzas() {
        return dao.getSpecialtyPizzas();
    }
}
