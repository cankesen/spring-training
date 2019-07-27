--CAR
insert into car(id, brand, model, vin) values (1, 'Audi', 'a4', 'HKD75J34534NU');
insert into car(id, brand, model, vin) values (2, 'Audi', 'a5', 'HKD7579878JNU');
insert into car(id, brand, model, vin) values (3, 'Audi', 'a6', 'HKD7534553JNU');
insert into car(id, brand, model, vin) values (4, 'Bmw', 'x1', 'HKD7533J33NU');
insert into car(id, brand, model, vin) values (5, 'Bmw', '318', 'HKD75J8888NU');
insert into car(id, brand, model, vin) values (6, 'Mercedes', 'C-Class', 'HKD23FFG75JNU');
insert into car(id, brand, model, vin) values (7, 'Batman Inc', 'Batmobil', 'JDLJKDLKJ765');
--ACTOR
insert into person (address_postal_code, address_street, name, car_id, person_type, id) values (12345, 'Washington Street', 'Keanu Reeves', 1,'Actor', 1);
insert into person (address_postal_code, address_street, name, car_id, person_type, id) values (56767, 'Denver Street', 'Laurance Fishburn', 2, 'Actor', 2);
insert into person (address_postal_code, address_street, name, car_id, person_type, id) values (23456, 'Burlington Street', 'Carie-Ann Moss', 3,'Actor', 3);
insert into person (address_postal_code, address_street, name, car_id, person_type, id) values (53453, 'Burlington Street', 'Hugo Weaving', 4,'Actor', 4);
insert into person (address_postal_code, address_street, name, car_id, person_type, id) values (12345, 'Elm Street', 'Lenoardo Di Caprio', 5,'Actor', 5);
insert into person (address_postal_code, address_street, name, car_id, person_type, id) values (89767, 'London Street', 'Kate Winslet', 6, 'Actor', 6);
insert into person (address_postal_code, address_street, name, car_id, person_type, id) values (56767, 'Orlando Street', 'Matthew McConaughy', NULL, 'Actor', 7);
--DIRECTOR
insert into person (address_postal_code, address_street, name, car_id, person_type, id) values (345345, 'New York Street', 'Christopher Nolan', 7 ,'Director', 8);
insert into person (address_postal_code, address_street, name, car_id, person_type, id) values (56767, 'Vienna Street', 'James Cameron', NULL , 'Director', 9);
insert into person (address_postal_code, address_street, name, car_id, person_type, id) values (345345, 'Berlin Street', 'Lana Wachowski', NULL , 'Director', 10);
insert into person (address_postal_code, address_street, name, car_id, person_type, id) values (55767, 'Paris Street', 'Chad Stahelski', NULL , 'Director', 11);
--BIOGRAPHY
insert into biography( text, person_id) values('i am Keanu', 1);
insert into biography( text, person_id) values('i am Carie', 3);
insert into biography( text, person_id) values('i am Leo', 5);
insert into biography( text, person_id) values( 'i am Christoph, i am the best', 6);
--MOVIE
insert into movie (director_id, genre, title, id) values (10, 'SCI_FI', 'Matrix', 1);
insert into movie (director_id, genre, title, id) values (9, 'DRAMA', 'Titanic', 2);
insert into movie (director_id, genre, title, id) values (11, 'ACTION', 'John Wick', 3);
insert into movie (director_id, genre, title, id) values (8, 'ACTION', 'Inception', 4);
insert into movie (director_id, genre, title, id) values (8, 'SCI_FI', 'Interstellar', 5);
--ACTS
insert into act(role, movie_id, actor_id) values('Neo',1,1);
insert into act(role, movie_id, actor_id) values('Morpheus',1,2);
insert into act(role, movie_id, actor_id) values('Trinity',1,3);
insert into act(role, movie_id, actor_id) values('Agent',1,4);
insert into act(role, movie_id, actor_id) values('Jack',2,5);
insert into act(role, movie_id, actor_id) values('Rose',2,6);
insert into act(role, movie_id, actor_id) values('John Wick',3,1);
insert into act(role, movie_id, actor_id) values('Cobb',4,5);
insert into act(role, movie_id, actor_id) values('Cooper',5,6);
--PRIZE
insert into prize(id, date, name, movie_id) values (1, TO_DATE('17/12/2009', 'DD/MM/YYYY'), 'Oscar Best Movie', 1);
insert into prize(id, date, name, movie_id) values (2, TO_DATE('17/12/2009', 'DD/MM/YYYY'), 'Oscar Best Script', 1);
insert into prize(id, date, name, movie_id) values (3, TO_DATE('17/12/2009', 'DD/MM/YYYY'), 'Oscar Best Scene', 1);
insert into prize(id, date, name, movie_id) values (4, TO_DATE('15/11/2007', 'DD/MM/YYYY'), 'Oscar Best Movie', 2);
insert into prize(id, date, name, movie_id) values (5, TO_DATE('05/02/2007', 'DD/MM/YYYY'), 'Cannes Gold', 2);
insert into prize(id, date, name, movie_id) values (6, TO_DATE('01/08/2016', 'DD/MM/YYYY'), 'Berlinale Gold', 3);
insert into prize(id, date, name, movie_id) values (7, TO_DATE('16/10/2019', 'DD/MM/YYYY'), 'Golden Globe Best Movie', 4);
--PRODUCTION COMPANY
insert into production_company(id, name) values(1, 'Universal Studios');
insert into production_company(id, name) values(2, 'Warner Bros');
insert into production_company(id, name) values(3, 'Disney');
insert into production_company(id, name) values(4, '21th Century');
--PRODUCES
insert into produces(production_company_id, movie_id) values(1,1);
insert into produces(production_company_id, movie_id) values(2,1);
insert into produces(production_company_id, movie_id) values(2,2);
insert into produces(production_company_id, movie_id) values(3,3);
insert into produces(production_company_id, movie_id) values(4,4);
insert into produces(production_company_id, movie_id) values(4,2);


