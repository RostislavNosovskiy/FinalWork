-- 7. В подключенном MySQL репозитории создать базу данных “Друзья человека”
DROP DATABASE IF EXISTS HumanFriends;
CREATE DATABASE IF NOT EXISTS HumanFriends;
USE HumanFriends;

-- 8. Создать таблицы с иерархией из диаграммы в БД
DROP TABLE IF  EXISTS Commands;
CREATE TABLE IF NOT  EXISTS Commands
(
id INT PRIMARY KEY NOT NULL auto_increment,
command_name VARCHAR(35),
description VARCHAR(200)
);

DROP TABLE IF  EXISTS AnimalGroup;
CREATE TABLE IF NOT  EXISTS AnimalGroup
(
id INT PRIMARY KEY NOT NULL auto_increment,
group_name VARCHAR(35)
);

DROP TABLE IF  EXISTS GenusOfTheAninal;
CREATE TABLE IF NOT  EXISTS GenusOfTheAninal
(
id INT PRIMARY KEY NOT NULL auto_increment,
genus_name VARCHAR(35), 
group_id iNT,
foreign key(group_id) REFERENCES AnimalGroup(id)
ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF  EXISTS AllAnimals;
CREATE TABLE IF NOT  EXISTS AllAnimals
(
id INT PRIMARY KEY NOT NULL auto_increment,
animal_name VARCHAR(35),
birth_date DATE,
genus_id iNT,
foreign key(genus_id) REFERENCES GenusOfTheAninal(id)
ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF  EXISTS AnimalCommands;
CREATE TABLE IF NOT  EXISTS AnimalCommands
(
animal_id INT  NOT NULL ,
command_id INT  NOT NULL ,
primary key(command_id, animal_id),
foreign key(animal_id) REFERENCES AllAnimals(id)
ON DELETE CASCADE ON UPDATE CASCADE,
foreign key(command_id) REFERENCES Commands(id)
ON DELETE CASCADE ON UPDATE CASCADE
);

-- 9.Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения
INSERT INTO Commands(command_name)
VALUES
('Апорт'),
('Сидеть'),
('Голос'),
('Стоп'),
('Фас!'),
('Галоп'),
('Крутится в колесе');

INSERT INTO AnimalGroup(group_name)
VALUES
('Домашние животные'),
('Вьючные животные');

INSERT INTO GenusOfTheAninal(genus_name, group_id)
VALUES
('Собака', 1),
('Кошка', 1),
('Хомяк', 1),
('Лошадь', 2),
('Осёл', 2),
('Верблюд', 2);

INSERT INTO AllAnimals(animal_name, birth_date, genus_id)
VALUES
('Лайка', '2021-03-12', 1),
('Мухтар', '2020-07-17', 1),
('Арчи', '2019-04-03', 2),
('Стёпа', '2022-11-09', 3),
('Скакун', '2016-12-23', 4),
('Мустанг', '2021-05-30', 4),
('Иа', '2019-05-08', 5),
('Плевака', '2014-10-23', 6);

INSERT INTO AnimalCommands(animal_id, command_id)
VALUES 
(1, 1), (1, 2), (1,3),
(2, 1), (2, 2), (2,3), (2, 5),
(3, 2),
(4, 7),
(5, 4), (5, 6),
(6, 4), (6, 6),
(7, 4), 
(8, 4);

-- 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
DELETE FROM AllAnimals WHERE genus_id = 6;
CREATE TABLE HorseAndDonkey AS
SELECT * FROM Allanimals WHERE genus_id = 4
UNION 
SELECT * FROM Allanimals WHERE genus_id = 5;

SELECT * FROM HorseAndDonkey;

-- 11.Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, 
-- но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице
CREATE TABLE YoungAnimals AS
SELECT id, animal_name, birth_date, genus_id, 
datediff(curdate(), birth_date) DIV 30 as ageOnMounth
FROM AllAnimals
WHERE datediff(curdate(), birth_date) DIV 30 > 12 AND datediff(curdate(), birth_date) DIV 30 < 36;

SELECT * FROM YoungAnimals;

-- 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.
SELECT id, animal_name, birth_date,genus_id, 'HorseAndDonkey' AS GetFromTable FROM HorseAndDonkey 
UNION 
SELECT id, animal_name, birth_date,genus_id, 'YoungAnimals' AS GetFromTable FROM YoungAnimals ;
