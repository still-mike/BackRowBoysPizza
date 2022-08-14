package com.techelevator.dao.Pizza;

import com.techelevator.model.process.Board;
import com.techelevator.model.process.Ingredient;
import com.techelevator.model.process.Order;
import com.techelevator.model.process.Pizza;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPizzaDAO implements PizzaDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcPizzaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Pizza> getAllPizzas() {
        List<Pizza> pizzas = new ArrayList<>();
        String sql = "SELECT id, pizza_size, dough, shape, sauce_type, description, is_available, order_id, pizza_price, is_specialty, status, board_id " +
                "FROM pizzas;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
            Pizza pizza = mapRowToPizza(rowSet);
            pizzas.add(pizza);
        }
        return pizzas;
    }

    @Override
    public List<Pizza> getSpecialtyPizzas() {
        List<Pizza> pizzas = new ArrayList<>();
        String sql = "SELECT id, pizza_size, dough, shape, sauce_type, description, is_available, order_id, pizza_price, is_specialty, status, board_id " +
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
        String sql = "SELECT id, pizza_size, dough, shape, sauce_type, description, is_available, order_id, pizza_price, is_specialty, status, board_id " +
                "FROM pizzas WHERE id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, pizzaId);
        if (rowSet.next()) {
            Pizza pizza = mapRowToPizza(rowSet);
            pizza.setIngredients(getIngredientsForPizzaId(pizza.getId()));
            return pizza;
        } else {
            return null;
        }
    }

    @Override
    public Pizza createPizza(Pizza pizza) {
        String sql = "INSERT INTO pizzas (pizza_size, dough, shape, sauce_type, description, is_available, order_id, pizza_price, is_specialty, status, board_id ) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id;";
        Long newId = jdbcTemplate.queryForObject(sql, Long.class,
                pizza.getPizzaSize(),
                pizza.getDough(),
                pizza.getShape(),
                pizza.getSauceType(),
                pizza.getDescription(),
                pizza.isAvailable(),
                pizza.getOrderId(),
                pizza.getPizzaPrice(),
                pizza.getIsSpecialty(),
                pizza.getStatus(),
                pizza.getBoardId());
        pizza.setId(newId);

        return pizza;
    }

    @Override
    public boolean updatePizza(Pizza pizza) {
        String sql = "UPDATE pizzas SET pizza_size = ?, dough = ?, shape = ?, sauce_type = ?, description = ?," +
                " is_available = ?, order_id = ?, pizza_price = ?, is_specialty = ?, status = ?, board_id = ?, id = ? );";
        int count = jdbcTemplate.update(sql, pizza.getPizzaSize(), pizza.getDough(), pizza.getShape(), pizza.getSauceType(),
                pizza.getDescription(), pizza.isAvailable(), pizza.getOrderId(), pizza.getPizzaPrice(), pizza.getIsSpecialty(),
                pizza.getStatus(), pizza.getBoardId(), pizza.getId());

        return count == 1;
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
        pizza.setStatus(rowSet.getString("status"));
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
        String sql = "SELECT id, order_status, is_delivery, employee_name, order_time, cust_address, cust_email " +
                "FROM orders WHERE id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, orderId);
        if (rowSet.next()) {
            Order order = mapRowToOrder(rowSet);
            return order;
        } else {
            return null;
        }
    }


    //TODO - create order
        /** This works in pgadmin:
         * INSERT INTO orders (order_status, is_delivery, employee_name, order_time, cust_address, cust_email)
         VALUES ('test7',FALSE,'test employee',current_timestamp,'123 Maple Street','test@gmail.com');
         INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,is_available,pizza_price,is_specialty, status, board_id, order_id)
         VALUES ('large','classic','round','traditional red','Test 7 - THE FINKELDEY - smoked bbq sauce, housemade mozzarella, fontina,
         roasted chicken, red onion, banana pepper',TRUE,19.99,TRUE, 'Pending',1, (SELECT MAX(id)FROM orders));

         -- Use Tenmo @Transactional transfer as a model.
         */

    @Transactional
    @Override
    public Order createOrder(Order order, Pizza pizza) {
        String sql = "INSERT INTO orders (order_status, is_delivery, employee_name, order_time, cust_address, " +
                "cust_email) VALUES (?, ?, ?, ?, ?, ?) RETURNING id;";
        Long newId = jdbcTemplate.queryForObject(sql, long.class, order.getOrderStatus(), order.isDelivery(),
                order.getEmployeeName(), order.getOrderTime(), order.getCustAddress(), order.getCustEmail());
        order.setId(newId);

        sql = " INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,is_available,pizza_price,is_specialty," +
                " status, board_id, order_id) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,(SELECT MAX(id)FROM orders));";
        jdbcTemplate.update(sql);
        return order;
    }

//    //test of ingredient looping
//    public boolean addIngredients(Pizza pizza){
//        List<Ingredient> ingredients = new ArrayList<>();
//        ingredients = pizza.getIngredients();
//        if (ingredients.size() != 0 )  {
//            for (Ingredient ing : ingredients ){
//                String name = ing.getIngredientName();
//
//            }
//
//        }
//    }


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


    //todo - createBoard maybe not needed?
    @Override
    public Board createBoard(Board board) {
        return null;
    }

    //todo - deleteBoard maybe not needed?
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
        String sql = "SELECT id, pizza_size, dough, shape, sauce_type, description, is_available, order_id, pizza_price, is_specialty, status, board_id FROM pizzas WHERE board_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, boardId);
        while (rowSet.next()) {
            Pizza pizza = mapRowToPizza(rowSet);
/*            TODO - if we want ingredients nested -- we need to think it through.
               Kanban did not have a comment duplicated on multiple cards.
                How do we duplicate an ingredient?
                pizza.setIngredients(???)*/
//            card.setComments(getCommentsForCardId(card.getId()));
            result.add(pizza);
        }
        return result;
    }

//comment / ingredient mapping

    @Override
    public List<Ingredient> getAllIngredients() {
        List<Ingredient> result = new ArrayList<>();
        String sql = "SELECT id, ingredient_name, tier, available, ingredient_price FROM ingredients;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
            Ingredient ingredient = mapRowToIngredient(rowSet);
            result.add(ingredient);
        }
        return result;
    }
    @Override
    public List<Ingredient> getIngredientsForPizzaId(long pizzaId) {
        List<Ingredient> result = new ArrayList<>();
        String sql = "SELECT i.id, i.ingredient_name, i.tier, i.available, i.ingredient_price FROM ingredients i " +
                "JOIN pizza_ingredients pi ON i.id = pi.ingredient_id " +
                "JOIN pizzas p ON pi.pizza_id = p.id " +
                "WHERE p.id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, pizzaId);
        while (rowSet.next()) {
            Ingredient ingredient = mapRowToIngredient(rowSet);
            result.add(ingredient);
        }
        return result;
    }

    public Ingredient mapRowToIngredient(SqlRowSet rowSet) {
        Ingredient result = new Ingredient();
        result.setId(rowSet.getLong("id"));
        result.setIngredientName(rowSet.getString("ingredient_name"));
        result.setTier((rowSet.getString("tier")));
        result.setIngredientPrice(rowSet.getBigDecimal("ingredient_price"));
        result.setAvailable(rowSet.getBoolean("available"));
        return result;
    }
}
