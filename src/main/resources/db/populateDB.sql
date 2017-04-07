DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals (user_id, description, calories, date_time) VALUES
  (100001, 'Полюстрово с лапшей', 1001, '2017-04-06 10:30');
INSERT INTO meals (user_id, description, calories, date_time) VALUES
  (100001, 'Биточек говяжий с яйцом', 400, '2017-04-06 15:30');
INSERT INTO meals (user_id, description, calories, date_time) VALUES
  (100001, 'Хлеб с маслом', 600, '2017-04-06 20:20');
INSERT INTO meals (user_id, description, calories, date_time) VALUES
  (100000, 'Жульен с грибами', 400, '2017-04-07 9:00');
INSERT INTO meals (user_id, description, calories, date_time) VALUES
  (100000, 'Индейка в брусничном соусе', 600, '2017-04-07 14:23');
INSERT INTO meals (user_id, description, calories, date_time) VALUES
  (100000, 'Котлета Пожарская', 400, '2017-04-07 21:13');
INSERT INTO meals (user_id, description, calories, date_time) VALUES
  (100000, 'Последний пир', 10000, '2017-04-08 15:00');