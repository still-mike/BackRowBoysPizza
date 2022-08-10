package com.techelevator.dao.Pizza;

import com.techelevator.model.process.Pizza;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPizzaDAO implements PizzaDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcPizzaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Pizza> getSpecialtyPizzas() {
        List<Pizza> pizzas = new ArrayList<>();
        String sql = "SELECT id, pizza_size, dough, shape, sauce_type, description, order_id, pizza_price, is_specialty " +
                "FROM pizzas " +
                "WHERE is_specialty IS TRUE;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
            Pizza pizza = mapRowToPizza(rowSet);
            pizzas.add(pizza);
        }
        return pizzas;
    }

    @Override
    public Pizza getPizza(long pizzaId) {
        String sql = "SELECT id, pizza_size, dough, shape, sauce_type, description, order_id, pizza_price, is_specialty " +
                "FROM pizzas WHERE id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, pizzaId);
        if (rowSet.next()) {
            Pizza pizza = mapRowToPizza(rowSet);
            return pizza;
        } else {
            return null;
        }
    }

    @Override
    public Pizza createPizza(Pizza pizza) {
        String sql = "INSERT INTO pizzas (pizza_size, dough, shape, sauce_type, description, pizza_price, is_specialty) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING id;";
        Long newId = jdbcTemplate.queryForObject(sql, Long.class,
                pizza.getPizzaSize(),
                pizza.getDough(),
                pizza.getShape(),
                pizza.getSauceType(),
                pizza.getDescription(),
                pizza.getPizzaPrice(),
                pizza.getIsSpecialty());
        pizza.setId(newId);

        return pizza;
    }

    @Override
    public boolean updatePizza(Pizza pizza) {
        return false;
    }

    @Override
    public boolean deletePizza(long pizzaId) {
        String sql = "DELETE FROM pizzas WHERE id = ?;";
        int count = jdbcTemplate.update(sql, pizzaId);
        return count == 1;
    }


    private Pizza mapRowToPizza(SqlRowSet rowSet) {
        Pizza pizza = new Pizza();
        pizza.setId(rowSet.getLong("id"));
        pizza.setPizzaSize(rowSet.getString("pizza_size"));
        pizza.setDough(rowSet.getString("dough"));
        pizza.setShape(rowSet.getString("shape"));
        pizza.setSauceType(rowSet.getString("sauce_type"));
        pizza.setDescription(rowSet.getString("description"));
        pizza.setPizzaPrice(rowSet.getBigDecimal("pizza_price"));
        pizza.setIsSpecialty(rowSet.getBoolean("is_specialty"));
        pizza.setOrderId(rowSet.getLong("order_id"));
        return pizza;
    }
}
