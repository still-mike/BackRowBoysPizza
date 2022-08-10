package com.techelevator.dao.Order;

import com.techelevator.model.process.Order;

import java.util.List;

public interface OrderDAO {

    public List<Order> getAllOrders();

    public Order getOrder(long orderId);

    public Order createOrder(Order order);

    public boolean updateOrder(Order order);

    public boolean deleteOrder(long orderId);

}
