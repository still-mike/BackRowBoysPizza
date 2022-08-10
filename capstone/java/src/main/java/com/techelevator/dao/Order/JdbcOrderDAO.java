package com.techelevator.dao.Order;

import com.techelevator.model.process.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcOrderDAO implements OrderDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcOrderDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT id, order_status, is_delivery, employee_name, order_time, cust_address, cust_email " +
                "FROM orders;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
            Order order = mapRowToOrder(rowSet); //TODO went to create map, come back to here,

            //TODO - determine if we need functionality like this: board.setCards(getCardsForBoardId(board.getId()));
        }
        return null;
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
        //TODO - stopped here for lunch, looking at kanban as model.

        return result;
    }




}
