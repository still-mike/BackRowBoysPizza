
BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

-- boards
INSERT INTO boards (id, title, background_color) VALUES (1, 'Specialty Pizzas', '#1bb698');
INSERT INTO boards (id, title, background_color) VALUES (2, 'All Pizzas', '#fb826f');
INSERT INTO boards (id, title, background_color) VALUES (3, 'Orders', '#35284f');

-- Insert large specialty pies
INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,is_available,pizza_price,is_specialty, status, board_id)
VALUES ('large','classic','round','traditional red','THE FETTIG - balsamic drizzle, housemade mozzarella, sundried tomato, walnuts, basil',TRUE,19.99,TRUE, 'Pending',1);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,is_available,pizza_price,is_specialty, status, board_id)
VALUES ('large','classic','round','traditional red','THE FINKELDEY - smoked bbq sauce, housemade mozzarella, fontina, roasted chicken, red onion, banana pepper',TRUE,19.99,TRUE, 'Pending',1);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,is_available,pizza_price,is_specialty, status, board_id)
VALUES ('large','classic','round','traditional red','THE NOWELL - parmigiano, ricotta fonduta, baby spinach, onion, roasted garlic, chili flake',TRUE,19.99,TRUE, 'Pending',1);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,is_available,pizza_price,is_specialty, status, board_id)
VALUES ('large','classic','round','traditional red','THE STILL - white pie, sriracha honey, cheese blend, brussels, bacon, , shaved red onion',TRUE,19.99,TRUE, 'Pending',1);

-- Insert medium specialty pies
INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,is_available,pizza_price,is_specialty, status, board_id)
VALUES ('medium','classic','round','traditional red','THE FETTIG - balsamic drizzle, housemade mozzarella, sundried tomato, walnuts, basil',TRUE,16.99,TRUE, 'Pending',1);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,is_available,pizza_price,is_specialty, status, board_id)
VALUES ('medium','classic','round','traditional red','THE FINKELDEY - smoked bbq sauce, housemade mozzarella, fontina, roasted chicken, red onion, banana pepper',TRUE,16.99,TRUE, 'Pending',1);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,is_available,pizza_price,is_specialty, status, board_id)
VALUES ('medium','classic','round','traditional red','THE NOWELL - parmigiano, ricotta fonduta, baby spinach, onion, roasted garlic, chili flake',TRUE,16.99,TRUE, 'Ready',1);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,is_available,pizza_price,is_specialty, status, board_id)
VALUES ('medium','classic','round','traditional red','THE STILL - white pie, sriracha honey, cheese blend, brussels, bacon, , shaved red onion',TRUE,16.99,TRUE, 'Ready',1);

-- Insert small specialty pies
INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,is_available,pizza_price,is_specialty, status, board_id)
VALUES ('small','classic','round','traditional red','THE FETTIG - balsamic drizzle, housemade mozzarella, sundried tomato, walnuts, basil',TRUE,14.99,TRUE, 'Ready',1);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,is_available,pizza_price,is_specialty, status, board_id)
VALUES ('small','classic','round','traditional red','THE FINKELDEY - smoked bbq sauce, housemade mozzarella, fontina, roasted chicken, red onion, banana pepper',TRUE,14.99,TRUE, 'Completed', 1);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,is_available,pizza_price,is_specialty, status, board_id)
VALUES ('small','classic','round','traditional red','THE NOWELL - parmigiano, ricotta fonduta, baby spinach, onion, roasted garlic, chili flake',TRUE,14.99,TRUE, 'Completed',1);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,is_available,pizza_price,is_specialty, status, board_id)
VALUES ('small','classic','round','traditional red','THE STILL - white pie, sriracha honey, cheese blend, brussels, bacon, , shaved red onion',TRUE,14.99,TRUE, 'Cancelled',1);


--add standard toppings to the ingredient table
INSERT INTO ingredients (ingredient_name,tier,available,ingredient_price)
VALUES ('Red onion','Standard',TRUE,.25);

INSERT INTO ingredients (ingredient_name,tier,available,ingredient_price)
VALUES ('Sweet peppers','Standard',TRUE,.25);

INSERT INTO ingredients (ingredient_name,tier,available,ingredient_price)
VALUES ('Spinach','Standard',TRUE,.25);

INSERT INTO ingredients (ingredient_name,tier,available,ingredient_price)
VALUES ('Broccoli','Standard',TRUE,.25);

INSERT INTO ingredients (ingredient_name,tier,available,ingredient_price)
VALUES ('Mushroom','Standard',TRUE,.25);

INSERT INTO ingredients (ingredient_name,tier,available,ingredient_price)
VALUES ('Ham','Standard',TRUE,.25);

INSERT INTO ingredients (ingredient_name,tier,available,ingredient_price)
VALUES ('Jalapeño','Standard',TRUE,.25);

INSERT INTO ingredients (ingredient_name,tier,available,ingredient_price)
VALUES ('Black olive','Standard',TRUE,.25);

INSERT INTO ingredients (ingredient_name,tier,available,ingredient_price)
VALUES ('Pepperoni','Standard',TRUE,.25);

--add premium toppings to the ingredient table
INSERT INTO ingredients (ingredient_name,tier,available,ingredient_price)
VALUES ('Grilled Chicken','Premium',TRUE,.50);

INSERT INTO ingredients (ingredient_name,tier,available,ingredient_price)
VALUES ('Spicy Meatball','Premium',TRUE,.50);

INSERT INTO ingredients (ingredient_name,tier,available,ingredient_price)
VALUES ('Broccoli Rabe','Premium',TRUE,.50);

INSERT INTO ingredients (ingredient_name,tier,available,ingredient_price)
VALUES ('Fennel sausage','Premium',TRUE,.50);

INSERT INTO ingredients (ingredient_name,tier,available,ingredient_price)
VALUES ('Marinated tofu','Premium',TRUE,.50);

INSERT INTO ingredients (ingredient_name,tier,available,ingredient_price)
VALUES ('Fried chickpeas','Premium',TRUE,.50);

INSERT INTO ingredients (ingredient_name,tier,available,ingredient_price)
VALUES ('Crispy Pancetta','Premium',TRUE,.50);

INSERT INTO ingredients (ingredient_name,tier,available,ingredient_price)
VALUES ('Sauteed spinach','Premium',TRUE,.50);

INSERT INTO ingredients (ingredient_name,tier,available,ingredient_price)
VALUES ('Grilled pineapple','Premium',TRUE,.50);

--test order
INSERT INTO orders (order_status, is_delivery, employee_name, cust_address, cust_email)
VALUES ('test',FALSE,'test employee','123 Maple Street','test@gmail.com')
INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,is_available,pizza_price,is_specialty, status, board_id, order_id)
VALUES ('large','classic','round','traditional red','THE FINKELDEY - smoked bbq sauce, housemade mozzarella, fontina,
roasted chicken, red onion, banana pepper',TRUE,19.99,TRUE, 'Pending',1, (SELECT id FROM orders WHERE cust_email = "test@gmail.com"));


COMMIT TRANSACTION;
