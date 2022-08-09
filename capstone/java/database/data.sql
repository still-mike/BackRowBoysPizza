BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

-- Insert large specialty pies
INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price)
VALUES ('large','classic','round','traditional red','THE FETTIG - balsamic drizzle, housemade mozzarella, sundried tomato, walnuts, basil',19.99);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price)
VALUES ('large','classic','round','traditional red','THE FINKELDEY - smoked bbq sauce, housemade mozzarella, fontina, roasted chicken, red onion, banana pepper',19.99);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price)
VALUES ('large','classic','round','traditional red','THE NOWELL - parmigiano, ricotta fonduta, baby spinach, onion, roasted garlic, chili flake',19.99);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price)
VALUES ('large','classic','round','traditional red','THE STILL - white pie, sriracha honey, cheese blend, brussels, bacon, , shaved red onion',19.99);

-- Insert medium specialty pies
INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price)
VALUES ('medium','classic','round','traditional red','THE FETTIG - balsamic drizzle, housemade mozzarella, sundried tomato, walnuts, basil',16.99);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price)
VALUES ('medium','classic','round','traditional red','THE FINKELDEY - smoked bbq sauce, housemade mozzarella, fontina, roasted chicken, red onion, banana pepper',16.99);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price)
VALUES ('medium','classic','round','traditional red','THE NOWELL - parmigiano, ricotta fonduta, baby spinach, onion, roasted garlic, chili flake',16.99);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price)
VALUES ('medium','classic','round','traditional red','THE STILL - white pie, sriracha honey, cheese blend, brussels, bacon, , shaved red onion',16.99);

-- Insert small specialty pies
INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price)
VALUES ('small','classic','round','traditional red','THE FETTIG - balsamic drizzle, housemade mozzarella, sundried tomato, walnuts, basil',14.99);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price)
VALUES ('small','classic','round','traditional red','THE FINKELDEY - smoked bbq sauce, housemade mozzarella, fontina, roasted chicken, red onion, banana pepper',14.99);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price)
VALUES ('small','classic','round','traditional red','THE NOWELL - parmigiano, ricotta fonduta, baby spinach, onion, roasted garlic, chili flake',14.99);

INSERT INTO pizzas (pizza_size,dough,shape,sauce_type,description,pizza_price)
VALUES ('small','classic','round','traditional red','THE STILL - white pie, sriracha honey, cheese blend, brussels, bacon, , shaved red onion',14.99);

COMMIT TRANSACTION;
