--TODO need to add available to pizzas table
-- TODO add board data
-- TODO add board_id to pizzas

BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

-- boards
INSERT INTO boards (id, title, background_color) VALUES (1, 'Specialty Pizzas', '#1bb698');
INSERT INTO boards (id, title, background_color) VALUES (2, 'All Pizzas', '#fb826f');
INSERT INTO boards (id, title, background_color) VALUES (3, 'Orders', '#35284f');

-- Insert large specialty pies
INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price,is_specialty)
VALUES ('large','classic','round','traditional red','THE FETTIG - balsamic drizzle, housemade mozzarella, sundried tomato, walnuts, basil',19.99,TRUE);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price,is_specialty)
VALUES ('large','classic','round','traditional red','THE FINKELDEY - smoked bbq sauce, housemade mozzarella, fontina, roasted chicken, red onion, banana pepper',19.99,TRUE);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price,is_specialty)
VALUES ('large','classic','round','traditional red','THE NOWELL - parmigiano, ricotta fonduta, baby spinach, onion, roasted garlic, chili flake',19.99,TRUE);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price,is_specialty)
VALUES ('large','classic','round','traditional red','THE STILL - white pie, sriracha honey, cheese blend, brussels, bacon, , shaved red onion',19.99,TRUE);

-- Insert medium specialty pies
INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price,is_specialty)
VALUES ('medium','classic','round','traditional red','THE FETTIG - balsamic drizzle, housemade mozzarella, sundried tomato, walnuts, basil',16.99,TRUE);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price,is_specialty)
VALUES ('medium','classic','round','traditional red','THE FINKELDEY - smoked bbq sauce, housemade mozzarella, fontina, roasted chicken, red onion, banana pepper',16.99,TRUE);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price,is_specialty)
VALUES ('medium','classic','round','traditional red','THE NOWELL - parmigiano, ricotta fonduta, baby spinach, onion, roasted garlic, chili flake',16.99,TRUE);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price,is_specialty)
VALUES ('medium','classic','round','traditional red','THE STILL - white pie, sriracha honey, cheese blend, brussels, bacon, , shaved red onion',16.99,TRUE);

-- Insert small specialty pies
INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price,is_specialty)
VALUES ('small','classic','round','traditional red','THE FETTIG - balsamic drizzle, housemade mozzarella, sundried tomato, walnuts, basil',14.99,TRUE);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price,is_specialty)
VALUES ('small','classic','round','traditional red','THE FINKELDEY - smoked bbq sauce, housemade mozzarella, fontina, roasted chicken, red onion, banana pepper',14.99,TRUE);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price,is_specialty)
VALUES ('small','classic','round','traditional red','THE NOWELL - parmigiano, ricotta fonduta, baby spinach, onion, roasted garlic, chili flake',14.99,TRUE);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price,is_specialty)
VALUES ('small','classic','round','traditional red','THE STILL - white pie, sriracha honey, cheese blend, brussels, bacon, , shaved red onion',14.99,TRUE);


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

COMMIT TRANSACTION;
