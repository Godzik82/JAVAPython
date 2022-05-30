-- SQLite
DROP TABLE armour;
DROP TABLE weapon;
DROP TABLE units;
DROP TABLE flyingUnit;
DROP TABLE magicUnit;
DROP TABLE groundUnit;


CREATE TABLE armour (
ArmourID INTEGER PRIMARY KEY AUTOINCREMENT,
class char CHECK (class IN ('body', 'boots', 'gloves', 'helmet')),
name char,
weigth int,
defence int,
streigth int);

INSERT INTO armour ('class', 'name', 'weigth', 'defence', 'streigth')
VALUES ('body', 'leather cape', 1, 5, 100),
    ('body', 'chainmail', 10, 25, 100),
    ('body', 'Damascus armor', 20, 50, 100),
    ('body', "God's armor", 30, 150, 100),
    ('helmet', 'regular helmet', 2, 5, 100),
    ('helmet', 'Heroic helmet', 10, 5, 100),
    ('helmet', 'minotaur helmet', 20, 50, 100),
    ('helmet', 'Dragon helmet', 30, 150, 100),
    ('boots', 'Soldier boots', 1, 5, 100),
    ('boots', 'Fast boots', 10, 25, 100),
    ('boots', 'Knight boots', 20, 50, 100),
    ('boots', 'dragon boots', 30, 150, 100),
    ('gloves', 'gloves', 1, 5, 100),
    ('gloves', 'Knight gloves', 10, 25, 100),
    ('gloves', 'Minotaur Gloves', 20, 50, 100),
    ('gloves', 'Dragon Gloves', 30, 150, 100);

CREATE TABLE weapon (
WeaponID INTEGER PRIMARY KEY AUTOINCREMENT,
class char CHECK (class IN ('sword', 'rifle', 'magic torch')),
name char,
weigth int,
damage int,
streigth int);

INSERT INTO weapon ('class', 'name', 'weigth', 'damage', 'streigth')
VALUES ('sword', 'wooden sword', 65, 10, 1000),
    ('sword', 'Ordinary Sword', 75, 15, 1000),
    ('sword', 'Sword-hoarder', 80, 20, 1000),
    ('sword', 'Excalibur', 90, 25, 1000),
    ('magic torch', 'Magic wand', 65, 10, 1000),
    ('magic torch', 'Staff of Cold', 75, 15, 1000),
    ('magic torch', 'Shaman Staff', 80, 20, 1000),
    ('magic torch', 'Scepter of Satan', 90, 25, 1000);

SELECT * FROM armour WHERE class = 'helmet';

CREATE TABLE units (
UnitID INTEGER PRIMARY KEY AUTOINCREMENT,
class char CHECK (class IN ('ground', 'flying', 'magic')),
name char,
hp int,
selfAttack int,
maxWeigth int,
mana int);

INSERT INTO units ('class', 'name', 'hp', 'selfAttack', 'maxWeigth', 'mana')
VALUES ('ground', 'Orc', 1000, 40, 50, null),
    ('ground', 'Elf', 850, 35, 40, null),
    ('ground', 'Paladin', 950, 45, 50, null),
    ('ground', 'Gnome', 800, 40, 30, null),
    ('ground', 'Golem', 1500, 50, 60, null),
    ('flying', 'Dragon', 1000, 40, null, null),
    ('flying', 'Manticora', 850, 35, null, null),
    ('flying', 'Griffon', 950, 45, null, null),
    ('magic', 'Маг', 1000, 40, 50, 60),
    ('magic', 'Джин', 850, 35, 40, 70),
    ('magic', 'Экзорцист', 950, 45, 50, 60),
    ('magic', 'Ведьма', 800, 40, 30, 50),
    ('magic', 'Ведьмаг', 1500, 50, 60, 100);




