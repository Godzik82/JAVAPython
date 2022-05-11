-- SQLite
DROP TABLE cars;
DROP TABLE shops;
DROP TABLE users;
DROP TABLE CarsUsers;

CREATE TABLE cars (
    CarID INTEGER  PRIMARY KEY AUTOINCREMENT,
    name char,
    color char,
    model char,
    speed int,
    ShopID int,
    FOREIGN KEY (ShopID) REFERENCES shops(ShopID));

INSERT INTO cars ('name', 'color', 'model', 'speed', 'ShopID')
VALUES ('KIA', 'red', 'RIO', 100, 1),
    ('BMW', 'black', 'X5', 150, 2),
    ('MAZDA', 'blue', 'CX-9', 160, 1),
    ('VOLVO', 'grey', 'XC-80', 140, 3);

CREATE TABLE shops (
    ShopID INTEGER  PRIMARY KEY AUTOINCREMENT,
    name char,
    address char);

INSERT INTO shops ('name', 'address')
VALUES ('VIP-AUTO', 'Lenina, 4'),
    ('BMW-AUTO', 'Svoboda, 234'),
    ('AUTO-MIR', 'Mira, 2'),
    ('KIA-CENTER', 'Sadovaya, 14');


CREATE TABLE users (
    UserID INTEGER  PRIMARY KEY AUTOINCREMENT,
    name char,
    surname char,
    money int,
    birthday datetime,
    CarID int);

INSERT INTO users ('name', 'surname', 'money', 'birthday')
VALUES ('Ivan', 'Ivanov', 1000, '12.12.2000'),
    ('Peter', 'Petrov', 2000, '01.05.2003'),
    ('Dmitriy', 'Surkov', 3000, '10.10.2001'),
    ('Oleg', 'Starikov', 4000, '23.06.2002');

CREATE TABLE CarsUsers (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    CarID int,
    UserID int,
    FOREIGN KEY (CarID) REFERENCES cars(CarID),
    FOREIGN KEY (UserID) REFERENCES users(UserID));

INSERT INTO CarsUsers ('CarID', 'UserID')
VALUES (1, 1),
    (1, 2),
    (2, 1),
    (3, 3);

SELECT u.name, u.surname, c.model FROM users u
JOIN CarsUsers cu
ON cu.UserID = u.UserID
JOIN cars c
ON cu.CarID = c.CarID;

SELECT s.name, c.model FROM shops s, cars c
WHERE s.ShopID = c.ShopID;


