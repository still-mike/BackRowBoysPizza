package com.techelevator.dao.Pizza;

import com.techelevator.model.process.Board;
import com.techelevator.model.process.Order;
import com.techelevator.model.process.Pizza;

import java.util.List;

public interface PizzaDAO {

    public List<Pizza> getAllPizzas();

    public List<Pizza> getSpecialtyPizzas();

    public Pizza getPizza(long pizzaId);

    public Pizza createPizza(Pizza pizza);

//    public boolean updatePizza(Pizza pizza);

    public boolean deletePizza(long pizzaID);

//  order

    public List<Order> getAllOrders();

    public Order getOrder(long orderId);

    public Order createOrder(Order order);

    public boolean updateOrder(Order order);

    public boolean deleteOrder(long orderId);

//  board

    public List<Board> getAllBoards();

    public Board getBoard(long boardId);

    public Board createBoard(Board board);

    public boolean deleteBoard(long boardId);

}
