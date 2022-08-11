package com.techelevator.dao.Pizza;

import com.techelevator.model.process.Board;
import com.techelevator.model.process.Order;
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
        String sql = "SELECT id, pizza_size, dough, shape, sauce_type, description, is_available, order_id, pizza_price, is_specialty, board_id " +
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
        String sql = "SELECT id, pizza_size, dough, shape, sauce_type, description, is_available, order_id, pizza_price, is_specialty, board_id " +
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
        pizza.setBoardId(rowSet.getLong("board_id"));
        pizza.setAvailable(rowSet.getBoolean("is_available"));
        return pizza;
    }

    //    order

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT id, order_status, is_delivery, employee_name, order_time, cust_address, cust_email " +
                "FROM orders;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
            Order order = mapRowToOrder(rowSet);
            //TODO - determine if we need functionality like this: board.setCards(getCardsForBoardId(board.getId()));
            orders.add(order);
        }
        return orders;
    }

    @Override
    public Order getOrder(long orderId) {
        return null;
    }

    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public boolean updateOrder(Order order) {
        return false;
    }

    @Override
    public boolean deleteOrder(long orderId) {
        return false;
    }

    private Order mapRowToOrder(SqlRowSet rowset) {
        Order result = new Order();
        result.setId(rowset.getLong("id"));
        result.setOrderStatus(rowset.getString("order_status"));
        result.setDelivery(rowset.getBoolean("is_delivery"));
        result.setEmployeeName(rowset.getString("employee_name"));
        result.setOrderTime(rowset.getTimestamp("order_time").toLocalDateTime());
        result.setCustAddress(rowset.getString("cust_address"));
        result.setCustEmail(rowset.getString("cust_email"));
        return result;
    }

//    board

    @Override
    public List<Board> getAllBoards() {
        List<Board> result = new ArrayList<>();
        String sql = "SELECT id, title, background_color FROM boards;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
            Board board = mapRowToBoard(rowSet);
            board.setPizzas(getPizzasForBoardId(board.getId()));
            result.add(board);
        }
        return result;
    }

    @Override
    public Board getBoard(long boardId) {
        String sql = "SELECT id, title, background_color FROM boards WHERE id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, boardId);
        if (rowSet.next()) {
            Board board = mapRowToBoard(rowSet);
            board.setPizzas(getPizzasForBoardId(board.getId()));
            return board;
        } else {
            return null;
        }
    }


    //todo
    @Override
    public Board createBoard(Board board) {
        return null;
    }

    //todo
    @Override
    public boolean deleteBoard(long boardId) {
        return false;
    }

    private Board mapRowToBoard(SqlRowSet rowSet) {
        Board result = new Board();
        result.setId(rowSet.getLong("id"));
        result.setTitle(rowSet.getString("title"));
        result.setBackgroundColor(rowSet.getString("background_color"));
        return result;
    }

    private List<Pizza> getPizzasForBoardId(long boardId) {
        List<Pizza> result = new ArrayList<>();
        String sql = "SELECT id, pizza_size, dough, shape, sauce_type, description, order_id, pizza_price, is_specialty FROM pizzas WHERE board_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, boardId);
        while (rowSet.next()) {
            Pizza pizza = mapRowToPizza(rowSet);
/*            TODO - if we want ingredients nested -- we need to think it through.
               Kanban did not have a comment duplicated on multiple cards.
                How do we duplicate an ingredients?
                pizza.setIngredients(???)*/
//            card.setComments(getCommentsForCardId(card.getId()));
            result.add(pizza);
        }
        return result;
    }


}
